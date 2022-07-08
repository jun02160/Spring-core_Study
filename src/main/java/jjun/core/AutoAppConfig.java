package jjun.core;

import jjun.core.member.MemberRepository;
import jjun.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(   // 컴포넌트 스캔 사용
        // basePackages = "jjun.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes=Configuration.class)
)
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
