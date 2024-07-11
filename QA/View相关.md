## View的绘制流程
1. XML转换成View
   LayoutInflater，io解析xml，将标签名转化为View的名称,XML中的各种属性转化为AttributeSet对象,然后通过反射生成View对象
2. 