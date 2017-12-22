package com.alibaba.jdk.proxy.test;

import org.junit.Test;
import com.alibaba.jdk.proxy.Handler;
import com.alibaba.service.ICountService;
import com.alibaba.service.Impl.CountServiceImpl;


public class JDKProxyTest {

	public JDKProxyTest() {

	}

	@Test
	public void dynamicProxyTest() {
		// Ŀ�����
		ICountService service = new CountServiceImpl();
		Handler handler = new Handler();
		// ����һ���������
		ICountService proxy = (ICountService) handler.bind(service);
		// 1.�˴���ӡproxyʱ���ȵ���invoke()�����������
		System.out.println("proxy:" + proxy);

		proxy.updateCount();
		// 2.Ŀ�������κη������ᱻ����,�Ƿ����ָ��ֻ����ĳЩ����(��Ȼ������Spring AOP �������)
		proxy.queryCount();

	}

}
