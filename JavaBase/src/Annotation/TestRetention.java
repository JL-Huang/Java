package Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//��ʾ�����漶�𱣴��ע����Ϣ����������ע�����������
//ȡֵSOURCE(��Դ�ļ�����Ч)��CLASS(��class�ļ�����Ч)��RUNTIME(����ʱ��Ч�����Ա������ȡ)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestRetention {

}
