package br.com.atlantico.testProgramador.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SOAPWebServicesConfiguration {
	
	@Value("${atlantico.soap.namespace.uri}")
	private String endpontUri;

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
	    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
	    servlet.setApplicationContext(applicationContext);
	    servlet.setTransformWsdlLocations(true);
	    return new ServletRegistrationBean(servlet, "/ws/*");
	}
	
	@Bean
	public XsdSchema countriesSchema() {
	    return new SimpleXsdSchema(new ClassPathResource("mensagens.xsd"));
	}
	
	@Bean(name = "mensagens")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
	    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
	    wsdl11Definition.setPortTypeName("MensagensPort");
	    wsdl11Definition.setLocationUri("/ws");
	    wsdl11Definition.setTargetNamespace("http://www.atlantico.com.br/springsoap/gen");
	    wsdl11Definition.setSchema(countriesSchema);
	    return wsdl11Definition;
	}
	
}
