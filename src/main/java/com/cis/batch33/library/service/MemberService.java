package com.cis.batch33.library.service;

import com.cis.batch33.library.model.Member;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberService {

    private Map<Long, Member> memberMap = new HashMap<>();

    public Member createMember(Member member){

        // call the database
        Long memberId = new Random().nextLong();
        member.setMemberId(memberId);
        memberMap.put(memberId, member);
        return  member;
    }

    public Member updateMember(Member member){
        Long memberId = member.getMemberId();

        memberMap.put(memberId,member);

        return member;
    }

    public ArrayList<Member> getMembers(){
        ArrayList<Member> al = new ArrayList<>();

        for (Long key : memberMap.keySet()) {
            al.add(memberMap.get(key));
        }

        return al;
    }

    public Member deleteMember(Long memberId){
        Member member = memberMap.remove(memberId);
        return member;
    }

    public Member getMember(Long memberId) {
        return memberMap.get(memberId);

    }
}