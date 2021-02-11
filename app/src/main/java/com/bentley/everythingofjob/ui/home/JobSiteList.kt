package com.bentley.everythingofjob.ui.home

import com.bentley.data.model.JobSiteItem
import com.bentley.everythingofjob.R

object JobSiteList {

    private val list = listOf(
        JobSiteItem("원티드", "#스타트업 #추천 #채용보상금", R.drawable.wanted, "https://www.wanted.co.kr"),
        JobSiteItem("잡코리아", "#취업포탈", R.drawable.jobkorea, "https://www.jobkorea.co.kr/"),
        JobSiteItem("사람인", "#취업포탈", R.drawable.saramin, "https://www.saramin.co.kr"),
        JobSiteItem("워크넷", "#고용노동부 #실업급", R.drawable.worknet, "https://www.work.go.kr/"),
        JobSiteItem("인쿠르트", "#취업포탈", R.drawable.incruit, "https://www.incruit.com/"),
        JobSiteItem("로켓펀치", "#스타트업 #네트워크", R.drawable.rocketpunch, "https://www.rocketpunch.com/"),
        JobSiteItem("프로그래머스", "#IT #개발자", R.drawable.programmers, "https://programmers.co.kr/"),
        JobSiteItem("커리어", "#취업포탈", R.drawable.career, "http://www.career.co.kr/"),
        JobSiteItem("나라일터", "#공무원", R.drawable.nara, "https://www.gojobs.go.kr/frameMenu.do?url=apmList.do&menuNo=3"),
        JobSiteItem("메디잡", "#병원 #의료", R.drawable.medijob, "https://www.medijob.cc/"),
        JobSiteItem("널스잡", "#병원 #의료", R.drawable.nursejob, "https://www.nursejob.co.kr/"),
        JobSiteItem("잡티쳐", "#학원강사", R.drawable.jobteacher, "https://www.jobteacher.co.kr/"),
        JobSiteItem("헤어인잡", "#미용", R.drawable.hairinjob, "https://www.hairinjob.com/"),
        JobSiteItem("메디잡", "#방송 #언론", R.drawable.medijob, "https://www.mediajob.co.kr/"),
        JobSiteItem("알바몬", "#알바", R.drawable.albamon, "https://www.albamon.com/"),
        JobSiteItem("알바천국", "#알바", R.drawable.alba, "http://www.alba.co.kr/"),
        JobSiteItem("크몽", "#프리랜서", R.drawable.kmong, "https://kmong.com/"),
        JobSiteItem("숨고", "#프리랜서", R.drawable.soomgo, "https://soomgo.com/"),
    )

    private val list2 = listOf(
        JobSiteItem("크레딧잡", "#기업정보 #연봉", R.drawable.kreditjob, "https://kreditjob.com/"),
        JobSiteItem("잡플래닛", "#기업정보 #연봉", R.drawable.jobplanet, "https://www.jobplanet.co.kr/"),
        JobSiteItem("블라인드", "#기업정보 #익명커뮤니티", R.drawable.blind, "https://www.teamblind.com/kr/"),
        JobSiteItem("링크드인", "#글로벌 #네트워크", R.drawable.linkedin, "https://www.linkedin.com/"),
        JobSiteItem("리멤버 커리어", "#명함 #경력직", R.drawable.remember, "https://career.rememberapp.co.kr/"),
        JobSiteItem("학생독립만세", "#후불제 #취업교육", R.drawable.hakdokman, "https://www.hakdokman.com/"),
        JobSiteItem("코멘토", "#멘토링", R.drawable.comento, "https://comento.kr/"),
        JobSiteItem("자소설닷컴", "#이력서 #자소서", R.drawable.jasoseol, "https://jasoseol.com/"),
        JobSiteItem("독취사", "#커뮤니티 #다음카페", R.drawable.daumcafe, "https://m.cafe.daum.net/breakjob/"),
        JobSiteItem("닥취고취업", "#커뮤니티 #네이버카페", R.drawable.daumcafe, "https://m.cafe.daum.net/4toeic"),
        JobSiteItem("열린옷장", "#정장무료대여", R.drawable.opencloset, "https://theopencloset.net/"),
        JobSiteItem("서울일자리포탈", "#취업날개 #서울", R.drawable.seouljob, "https://job.seoul.go.kr")
    )
    fun fetchJobSiteData() = list

    fun fetchServiceData() = list2
}