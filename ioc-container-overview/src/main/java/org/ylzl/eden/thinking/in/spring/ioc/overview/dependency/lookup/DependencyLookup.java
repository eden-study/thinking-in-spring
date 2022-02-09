package org.ylzl.eden.thinking.in.spring.ioc.overview.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.ylzl.eden.thinking.in.spring.ioc.overview.domain.User;

/**
 * 依赖查找
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
public class DependencyLookup {

	public static void main(String[] args) {
		// 加载 XML 配置文件
		// 启动 Spring 应用上下文
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
		// 实时查找 Bean
		lookupInRealtime(beanFactory);
		// 延迟查找 Bean
		lookupInLazy(beanFactory);
	}

	private static void lookupInRealtime(BeanFactory beanFactory) {
		User user = (User) beanFactory.getBean("user"); // Spring 3.0 以前的版本不支持 jdk5（泛型）
		System.out.println("实时查找 Bean：" + user);
	}

	private static void lookupInLazy(BeanFactory beanFactory) {
		ObjectFactory<User> objectFactory =
			(ObjectFactory<User>) beanFactory.getBean("objectFactory");
		User user = objectFactory.getObject();
		System.out.println("延迟查找 Bean：" + user);
	}
}
