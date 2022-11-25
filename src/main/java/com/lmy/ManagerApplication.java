package com.lmy;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableSwaggerBootstrapUI
@EnableJpaRepositories
@SpringBootApplication
public class ManagerApplication {

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext context = SpringApplication.run(ManagerApplication.class, args);
		Environment environment = context.getBean(Environment.class);
		String host = InetAddress.getLocalHost().getHostAddress();
		String port = environment.getProperty("server.port");
		String path = environment.getProperty("server.servlet.context-path");
		System.out.println("图书管理系统启动成功！Started Success");
		System.out.println("后台接口：http://"+"127.0.0.1"+":"+port+path+"/doc.html");
		System.out.println("网络地址：http://"+host+":"+port+path);
		System.out.println("本地地址：http://"+"127.0.0.1"+":"+port+path);
	
	}

}
