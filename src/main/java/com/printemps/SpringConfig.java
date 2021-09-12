package com.printemps;

import com.printemps.repository.JdbcMemberRepository;
import com.printemps.repository.JpaMemberRepository;
import com.printemps.repository.MemberRepository;
import com.printemps.repository.MemoryMemberRepository;
import com.printemps.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

/*
    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        // return new JdbcMemberRepository(dataSource);
         return new JpaMemberRepository(em);
    }
 */
}
