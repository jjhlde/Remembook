package com.remembook.kimryoji.remembook.Interface;

import com.remembook.kimryoji.remembook.Pojo.BookRepo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by KimRyoji on 2017-04-10.
 */

public interface DaumApiService {

    /**
     * Daum 책 API에서 기본값으로 정보를 불러온다
     * @param apiKey apikey
     * @param title 검색할 제목
     * @param result 한 페이지에 출력될 결과 수 int(1~20)
     * @param sort 검색결과 정렬순서 string(accu : 정확도 / date : 최신자료)
     * @param pageno 검색결과 페이지 수 int(1~3)
     * @param output 출력 type
     * @return
     */
    @GET("/search/book")
    Call<BookRepo> getBookDefault(@Query("apikey") String apiKey, @Query("q") String title,@Query("result") int result,
                                  @Query("sort") String sort,@Query("pageno") int pageno,@Query("output") String output);

}
