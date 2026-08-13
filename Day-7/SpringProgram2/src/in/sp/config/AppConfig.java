package in.sp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.sp.beans.Student;

@Configuration
public class AppConfig
{
    @Bean
    public Student stdId()
    {
        Student std = new Student();
        
        std.setName("Deepak");
        std.setRollNo(102);       
        std.setEmailId("deepak@gmail.com");  
        
        return std;
    }
}