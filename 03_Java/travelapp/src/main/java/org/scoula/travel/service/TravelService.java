package org.scoula.travel.service;

public interface TravelService {
    // 전체관광지목록출력하기
    void printTravels ();

    // 특정권역의관광지목록출력하기
    void printTravelsByDistrict ();

    // 특정페이지의관광지목록출력하기
    void printTravelsByPage ();

    // 광광지상세보기
    void printTravel ();
}