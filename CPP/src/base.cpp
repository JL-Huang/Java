#include <iostream>
// using相当于import，头文件不应包含using声明
using std::cout;
using std::string;
using std::vector;
int val = 20;
int main(int argc, char const *argv[])
{
    int val = 0;
    while (val < 10)
    {
        val++;
    }
    for (int i = 0; i < 10; i++)
    {
    }
    extern int val;
    //::访问全局变量
    ::val;
    // 假定别的文件已经定义了a，哪怕本地没定义后面也可以直接用
    extern int a;
    a = 0;
    // int&在声明变量时是引用
    int &b = a;
    // &a赋值时是取地址，int* 是声明一个指针类型
    int *c = &a;
    // 直接*c是取这个指针地址对应的变量
    *c = 6;
    // d是*c指针指向的变量的引用
    int &d = *c;
    // c指针的地址指向d变量的地址
    c = &d;
    // e不指向任何位置
    int *e = 0;
    // 指向任意类型的指针
    void *f;
    // 对指针取地址，构造一个指向指针的指针
    int **g = &c;
    // h是指针c的引用
    int *&h = c;
    // 不可变的变量，底层const修饰指针时指针可变但指针指向对象不可变，可以j=c不可以*j=10;顶层const才是不可修改指针指向
    const int i = 1;
    const int *j = &a;
    int *const k = &a;
    // 都表示wagas等于double
    typedef double wagas;
    using wagas = double;
    typedef int *l;
    l *m = g;
    // 不使用强类型
    auto n = 1;
    decltype(n) o = 1;
    // 拷贝初始化"aaab"
    string p = "aaab";
    // 直接初始化
    string q(4, 'a');
    // 字符串是否为空
    p.empty();
    // true,因为是字典排序
    p > q;
    string r = p + q;
    for (int i = 0; i < r.size(); i++)
    {
        cout << r.at(i);
    }
    vector<int> s = {1, 2, 3};
    // 相当于t=s,拷贝副本
    vector<int> t(s);
    t.push_back(4);
    // 只读的迭代器
    for (std::vector<int>::const_iterator it = s.cbegin(); it != s.cend(); ++it)
    {
        std::cout << *it << " ";
    }
    // 字符串数组特殊的初始化,会默认带一个'/0'，哪怕不声明'/0'也是，所以初始化时容量要加一
    int u[4]={'a','b','c','/0'};
    // 4个指针构成的数组
    int *v[4];
    // 指向一个4个元素的数组的指针
    int (*w)[4]=&u;
    // 数组对象可以作为指针，指向第一个元素的地址，等价于&u[0]
    int *x=u;
    int y=*u+1;//取第一个值后加一
    int z=*(u+1);//指针偏移
    // 多维数组
    int aa[3][4];
    int (*bb)[4]=aa;
    bb=&aa[2];

    // a.cc中用了b.cc的函数，需要链接b.cc到a.cc
    // $ CC a.cc b.cc
}
