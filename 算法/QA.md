# Q&A
## ��Ŀ�ṹ
20+module��ͨ��buildgradleʵ��������ͨ������ʵ��ģ���ͨ�ŵ��ã����㲿�ַ�װΪsdk�����ṩ��sdk��ҵ���߼�ͨ��һ�����ߵ���app����ʵ��

mvp��mvp��presenter����view��view����presenter��ͨ���ӿڸ��£���Ҫд�ܶ�ӿ�
Mvvm������˼��������������model������ݸı�����viewmodel���ݱ����viewmodel���ݱ������view���£�livedataʵ��
���⣺
1. ���ݵ���
����������value��observe����Ϊ�ڲ���ͨ���Ա�livedate��version�Ա��ж��Ƿ񴥷��ģ����Ի��������ݵ��࣬��Ļ��ת���л�ϵͳ����
����취��1 ��һ��trigger��true-��false��observe��ʱ���ж�Ϊtrue��ִ��2��дlivedata���ڴ���observer��ʱ���¼һ��id��ִ�д���observe�ص���ʱ���ж����id�Ƿ��Ѿ����ڣ������˲Żص�onchange
2. ���ݶ�ʧ
����postvalue��ֵ��mpendingdata�������̶߳�һ��runable����runable��ʵ��setvalue��setvalue��observe�ǻ�Ծ����ص�
����취��1observforever�ֶ�������������2postvalue�ֶ���runable3��дobserve

