## 怎么用的
### 顶点着色器pointcloud.vert
1. 归一化将颜色从255映射到1
2. 计算顶点位置
vec4 position = uProjectMatrix * uViewMatrix * uModelMatrix * vec4(aPosition.x, aPosition.y, aPosition.z, 1);
   1. 模型矩阵：局部坐标系到世界坐标系，直接单位矩阵
   2. 视图矩阵：世界坐标系到相机坐标系，定义相机的位置、目标位置和上方向，一般是经度，纬度，半径，然后Matrix.setLookAtM得出
   3. 投影矩阵：相机坐标系变化到屏幕坐标系，正交是通过Matrix.orthoM，输入边界已经远近平面距离，透视是通过Matrix.perspectiveM，输入fov，宽高比以及远近平面距离
3. 设置点的大小gl_PointSize和最终位置gl_Position
4. 通过glGetUniformLocation将对vert里面属性的操作变为对java属性的操作
5. 创建VBO
   VBO是存储在显存中的缓冲区，VBO使得顶点数据在GPU中存储和处理，减少了从CPU到GPU的数据传输
   

### 片元着色器pointcloud.frag
对亮度饱和度对比度微调