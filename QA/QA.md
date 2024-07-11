# Q&A
## 最擅长什么
业务方面，比较擅长从混乱的代码逻辑的整理和归纳出一个比较清晰完备的流程，重构过几个模块，项目展示以及压缩上传
## 有什么短板
拿到一个产品需求首先想到的是怎么实现，事实上应该站在一个更全面的视角看，产品的需求角度可能是基于数据基于业务
技术的角度可以看到的是背后的实现，优化的方向以及潜在的风险，如果主动地去了解不同视角去结合可以得到给出更全面的结论，
而不仅仅是能不能做排期多久这样。 这方面有意识地在弥补，在技术上理解需求的同时会更主动了解业务背景去优化需求或者实现
## 项目结构
20+module，通过buildgradle实现依赖
每个模块中都有一个module类，将他注册到一个全局依赖的模块ModuleService，ModuleService通过反射获得每一个模块的module类和其中的方法
通过反射实现模块间通信调用，注册一个
拍摄部分封装为sdk对外提供，sdk内业务逻辑通过一个总线调用app主体实现

mvp：mvp中presenter持有view，view持有presenter，通过接口更新，需要写很多接口
Mvvm：最大的思想是数据驱动，model层的数据改变驱动viewmodel数据变更，viewmodel数据变更驱动view更新，livedata实现
问题：
1. 数据倒灌
现象：先设了value再observe，因为内部是通过对比livedate的version对比判断是否触发的，所以会引起数据倒灌，屏幕旋转，切换系统语言
解决办法：1 设一个trigger，true-》false，observe的时候判断为true才执行2重写livedata，在创建observer的时候记录一个id，执行触发observe回调的时候判断这个id是否已经存在，存在了才回调onchange
2. 数据丢失
现象：postvalue存值到mpendingdata，往主线程丢一个runable，在runable里实现setvalue，setvalue在observe非活跃不会回调
解决办法：1observforever手动管理生命周期2postvalue手动抛runable3重写observe

## Handler导致的内存泄露原因及其解决方案
非静态内部类或匿名内部类中创建了主线程handler，发送了延时消息，消息持有handler对象持有外部类对象导致不能回收
1.将持有Handler的子类设置成静态内部类,使用弱引用持有Activity实例 
2.当外部类结束生命周期时，removeCallbacksAndMessages(null)清空Handler内消息队列

## 子线程更新ui
通过ViewRootImpl.requestLayout()中调用checkThread()校验
onCreate时执,先requestLayout后调用，windowManager加view调用，surfaceView调用

## 主线程为什么不会因为Looper.loop()里的死循环卡死？
messageQueue.next没消息时会调用native的nativePollOnce()，主线程会释放CPU资源进入休眠状态，直到下个消息到达或者有事务发生 ，在native层会有一个读取端和一个写入端，当有消息发送过来
的时候会去唤醒读取端，然后进行消息发送与处理

## 通过Handler如何实现线程的切换
获取另一个线程的handler，用这个handler发送一个消息到messageQueue,looper读取到以后，message持有handler引用，会调用handler的dispatchMessage处理

## Looper 如何与 Thread 关联的
thread内部维护了一个threadlocalmap，key是threadlocal对象，vulue是泛型
ThreadLocal的set方法获取当前线程的threadlocalmap，找到自己对应的key存值进去
Looper里面有一个静态变量sThreadLocal，在prepare时key为sThreadLocal，value为自己存进去

## 为什么zygote进程跟其他进程通讯使用socket而不是binder
1. Binder虽然在内核，但是提供服务的是ServiceManager
这个时候如果要给AMS提供Binder IPC就需要等ServiceManager先初始化好，这个是没办法保证的，如果要保证这个先后顺序又要搞多一套进程通讯就更麻烦了。
2. 另外，由于Zygote进程只与少数几个进程进行通讯，使用Socket通讯的开销相对较小，因此选择Socket通讯更加合适。而且这里面是优化过的LocalSocket效率会更高

## 事件是先到DecorView还是先到Window
### ViewRootImpl -> DecorView -> Activity -> PhoneWindow -> DecorView
DecorView的dispatchTouchView并没有调用super,单纯的调用了mwindow.callback把事件交给activity,activity交给window，
window调用DecorView的super.dispatchTouchView，这个时候视为viewgroup

## ACTION_DOWN
如果down事件默认不拦截，非down事件mFirstTouchTarget不为空才不拦截，不拦截就是往下执行子view的ontouchevent
下次除down事件来的时候，会落到最后一个消费的viewgroup

## 三个核心事件
1、dispatchTouchEvent()：方法返回值为true表示事件被当前视图消费掉； 返回为false表示 停止往子View传
递和分发,交给父类的onTouchEvent处理
2、onInterceptTouchEvent() ： return false 表示不拦截，需要继续传递给子视图。return true 拦截这个事件
并交由自身的onTouchEvent方法进行消费.
3、 onTouchEvent() ： return false 是不消费事件，会被传递给父视图的onTouchEvent方法进行处理。return
true 是消费事件。



## apk组成
1. META-INF是签名文件夹。 存放签名信息
2. res存放资源文件的目录,resources.arsc 编译后的二进制资源索引
3. classes.dex 是k字节码 
4. AndroidManifest.xml 程序的全局清单配置文件
直接在android studio analysis apk，占比最多是四块
### res，asset
TinyPNG插件对png进行压缩，只保留xxhdpi，尽量用svg以及lottlie，避免使用帧动画
### class.dex
minifyEnabled true
移除未被使用的类和成员，并且会在优化动作执行之后再次执行，因为优化后可能会再次暴露一些未被使用的类和成员
反射，WebView中JavaScript调用的方法，jni，与服务端交互时的解析类
### lib
strip去掉符号表
采用动态化加载so
启动app时,创建classloader实例，将so文件目录注入相关字段
system.load从classloader指定目录中按文件名寻找并加载so文件
1. 版本维护
判断 zip 是否有更新，如果有更新，则需要重新下载
2. 安全性问题：保证下载的zip一致
下载完解压之前对其做一次md5校验，通过接口下发，解压后校验文件大小
3. 注入classloader实例
通过反射修改systemNativeLibraryDirectories变量

## 协程
优点
1. 多个协程可以被安排在同一个线程上
2. 异常的处理和取消
3. 良好的资源管理，通过作用域实现
   使用的时候主要有几点
1. 协程作用域
   GlobeScope：作用域全局
    MainScope：主线程作用域
   lifecycleScope：跟生命周期绑定
    viewmodelScope：跟viewmodel生命周期绑定
自定义协程作用域：希望协程与某个特定的生命周期绑定
会等所有执行完才往下走
2. 协程启动方式
   launch：返回一个job表示协程状态 
   async/await: 返回异步执行结果
   runBlocking：阻塞当前协程直到执行完
3. 协程调度器
io，default，main
自定义调度器：需要特定的线程池上运行
继承CoroutineDispatcher，重写dispatch方法，入参传一个线程池
4. suspend
挂起函数：可以做到把当前线程挂起，转到另一个线程执行，执行完回到当前线程，本质上是回调
异常捕捉
launch不会往外抛异常
   CoroutineExceptionHandler只能处理当前域内开启的子协程或者当前协程抛出的异常

## 讲讲synchronized
基本的原理是通过synchronized限制访问，保证在同一时刻最多只有一个线程执行代码块，其他线程阻塞挂起
可以实现并发安全，但是JDK1.6之前消耗很大，因为一个线程挂起和恢复需要从用户态和内核态进行切换，很大开销
jdk1.6之后做了一些优化
### 锁升级
1. 偏向锁：加锁的时候标记当前线程，同一线程再次访问无需获得锁
2. 轻量锁：当出现了第二个线程竞争锁会撤销偏向锁，暂停持有偏向锁的线程，检查锁状态，然后恢复线程的运行，用自旋的方式尝试获取锁
3. 重量级锁：多个线程反复尝试获取轻量级锁会升级，，所有自旋等待的线程都会进入阻塞状态，等待重量级锁的释放。
锁合并锁消除：锁住更大的代码块减少锁的获取与释放，判断一些不存在竞争的场景去除锁
适应性自旋：一个线程成功获取了锁，且持锁时间较短，自旋次数增多，相符就很快进入阻塞

有一些功能上的限制，无法中断正在等待获取锁的线程，不能实现公平锁造成锁饥饿

## GCRoots
1. 虚拟机栈(栈桢中的本地变量表)中的引用的对象 
2. 方法区中的类静态属性引用的对象 
3. 方法区中的常量引用的对象 
4. 本地方法栈中JNI（Native方法）的引用的对象

opengl你们是怎么做的
算法生成一个ply文件，其实里面是一系列的数据
编码方式ascii或者binary，点云数量，xyzrgb
问题：加载速度大于渲染速度，导致生产的ply对象一直在本地，而且加载过程中的临时变量也占据很大的内存
优化：加快渲染，阻塞加载

## 本地数据和服务端数据同步
背景：每一套vr是一个项目，数据本地一份服务端一份，然后通过同步操作建立联系
问题：弱网环境修改后同步可能失败，失败后怎么处理？贝壳门店可以几个人一起采集一套VR操作同一个数据，怎么实现？
调研：
同步客户端服务器 (S-CS)：阻塞操作，不同步成功无法修改本地数据，微信
异步客户端服务器 (A-CS)：本地保存数据后台同步
异步对等方式 (A-P2P)：
选型：因为弱网环境很常见尤其海外，不能阻塞，所以采用了第二种
思路：主要三个问题
1.颗粒大小:当某个属性字段被修改过后，确定追踪这个字段还是追踪整个实例
2.记录变化:尝试同步时新内容覆盖掉服务端旧内容，如果服务端更新会提示冲突，提示保留哪个版本
3.删除处理：删除作为特殊key
实现：
1.同步时带时间戳，服务端校验时间戳比服务端更新才成功
2.失败key为字段，value为带时间戳的实例存放同步操作，确保本地对某个字段只保留最后一次操作
3.进app时会拉取实例，拉取成功提示用户触发同步

## hashmap
数组加链表，初始16的数组大小，根据哈希值和数组大小取余判断放的位置
如果哈希冲突就会以链表形式头插到前面
如果元素达到数组长度的0.75就会扩容，重新构建hashmap
为什么是0.75？hash碰撞概率在0.5左右最适中，跟负载因子有关，ln2=0.69，方便位运算
jdk7前扩容可能改变相对顺序，jdk8修复了，通过hashcode与16位无符号整数取异或

为什么线程不安全？
put的时候有新建链表节点写入内存的操作，可能会覆盖或者造成链表死循环
扩容时get会取到null

ConcurrentHashMap
jdk7之前是分段锁，一个Segment里包含一个HashEntry链表
为什么舍弃？内存不连续，没有根本解决，segment大的时候还是会造成性能下降
jdk8做几个操作
无哈希碰撞cas防止写入时覆盖或者死循环
有哈希碰撞首先判断这个节点的类型。如果该节点fh==MOVED(代表forwardingNode，数组正在进行扩容)的话，说明正在进行扩容，synchronize
CopyOnWriteArrayList
CopyOnWrite，读不加锁，写的时候新建一个

## 泛型
类型参数解决了元素的不确定性，其实是一个语法糖，在编译后就会泛型擦除用强转的方式实现调用

## JsBridge
对于Android调用JS代码的方法有2种：
1. 通过WebView的loadUrl（），调用WebView JS
2. 通过WebView的evaluateJavascript（），安卓4.4以后支持，可以获取回调
对于JS调用Android代码的方法有3种：
3. 通过 WebView的addJavascriptInterface（）进行对象映射，在js想要调用的native方法前加上 @JavascriptInterface，并mWebView.addJavascriptInterface(new AndroidtoJs(), "test")映射对象，有漏洞js拿到对象后可以反射获得Runtime，可以执行一些命令
4. 通过 WebViewClient 的shouldOverrideUrlLoading ()方法回调拦截 url，约定好scheme，拿返回值需要客户端再loadurl
5. 通过 WebChromeClient 的onJsAlert()、onJsConfirm()、onJsPrompt（）方法回调拦截JS对话框alert()、confirm()、prompt（） 消息，jsalert()时会触发
