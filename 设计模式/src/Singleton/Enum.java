package Singleton;
//其他类直接Enum.Instance就能获得单例
//唯一一个可以防止反射获得多个实例的单例实现方法,缺点是不能懒加载
public enum Enum {
Instance;
}
