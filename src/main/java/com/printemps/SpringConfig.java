package com.printemps;

import com.printemps.repository.JdbcMemberRepository;
import com.printemps.repository.MemberRepository;
import com.printemps.repository.MemoryMemberRepository;
import com.printemps.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcMemberRepository(dataSource);
    }
}
