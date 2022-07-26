package com.nackjun.poop_ver_01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;

public class ListviewActivity extends AppCompatActivity {

    private List<String> list;          // 데이터를 넣은 리스트변수
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        editSearch = (EditText) findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listView);

        // 리스트를 생성한다.
        list = new ArrayList<String>();

        // 검색에 사용할 데이터을 미리 저장한다.
        settingList();

        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new SearchAdapter(list, this);

        // 리스트뷰에 아답터를 연결한다.
        listView.setAdapter(adapter);

        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);
            }
        });


    }

    // 검색을 수행하는 메소드
    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).toLowerCase().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }

    // 검색에 사용될 데이터를 리스트에 추가한다.
    private void settingList(){
        list.add("[1호선] { 소요산 }  게이트 외부 / 맞이방 ");
        list.add("[1호선] { 동두천 }  게이트 외부 / 여객통로(1번출구방면) ");
        list.add("[1호선] { 보산 }  게이트 외부 / 맞이방 ");
        list.add("[1호선] { 동두천중앙 }  게이트 정보없음 / 정보없음 ");
        list.add("[1호선] { 지행 }  게이트 외부 / 3번출구(북부역사) ");
        list.add("[1호선] { 덕정 }  게이트 외부 / 맞이방 ");
        list.add("[1호선] { 덕계 }  게이트 정보없음 / 정보없음 ");
        list.add("[1호선] { 양주 }  게이트 외부 / 1번출구방향 ");
        list.add("[1호선] { 녹양 }  게이트 외부 / 1번출구 ");
        list.add("[1호선] { 가능 }  게이트 외부 / 1번출구와현금인출기사이 ");
        list.add("[1호선] { 의정부 }  게이트 외부 / 2,3번출구방향/4,5번출구방향 ");
        list.add("[1호선] { 회룡 }  게이트 외부 / 맞이방 ");
        list.add("[1호선] { 망월사 }  게이트 내부 / 북부:1,2번출구/남부:3번출구 ");
        list.add("[1호선] { 도봉산 }  게이트 외부 / 상행계단게이트(1,2번출구) ");
        list.add("[1호선] { 도봉 }  게이트 내부 / 1번출구방향 ");
        list.add("[1호선] { 방학 }  게이트 내부 / 1번,2번출구방향 ");
        list.add("[1호선] { 창동 }  게이트 외부 / 2번출구 ");
        list.add("[1호선] { 녹천 }  게이트 내부 / 북부맞이방인천행승강장방향 ");
        list.add("[1호선] { 월계 }  게이트 내부 / 1번 출구 ");
        list.add("[1호선] { 광운대 }  게이트 외부 / 광운대역1번출구방향(역사안에위치) ");
        list.add("[1호선] { 석계 }  게이트 내부 / 맞이방내 ");
        list.add("[1호선] { 신이문 }  게이트 내부 / 의정부행북쪽승강장(1·2·3번출구) ");
        list.add("[1호선] { 외대앞 }  게이트 정보없음 / 정보없음 ");
        list.add("[1호선] { 회기 }  게이트 외부 / 1번출구 ");
        list.add("[1호선] { 남영 }  게이트 정보없음 / 정보없음 ");
        list.add("[1호선] { 용산 }  게이트 내부 / 전철타는곳북쪽 ");
        list.add("[1호선] { 노량진 }  게이트 외부 / 1번 출구 ");
        list.add("[1호선] { 대방 }  게이트 외부 / 1번 출구 ");
        list.add("[1호선] { 신길 }  게이트 외부 / 1번출구 ");
        list.add("[1호선] { 영등포 }  게이트 내부 / 1번 출구 ");
        list.add("[1호선] { 신도림 }  게이트 내부 / 1번 출입구 ");
        list.add("[1호선] { 구로 }  게이트 내부 / 맞이방 ");
        list.add("[1호선] { 구일 }  게이트 내부 / 개표구앞 ");
        list.add("[1호선] { 개봉 }  게이트 외부 / 맞이방1번출구좌측 ");
        list.add("[1호선] { 오류동 }  게이트 외부 / 게이트나와서바로왼쪽 ");
        list.add("[1호선] { 온수 }  게이트 외부 / 인천방향게이트옆(7번출구) ");
        list.add("[1호선] { 역곡 }  게이트 외부 / 1번출구맞이방(남광장쪽) ");
        list.add("[1호선] { 소사 }  게이트 외부 / 1번출구전왼쪽 ");
        list.add("[1호선] { 부천 }  게이트 외부 / 2번출구옆 ");
        list.add("[1호선] { 중동 }  게이트 외부 / 1번출구 ");
        list.add("[1호선] { 송내 }  게이트 외부 / 1번출구남광장 ");
        list.add("[1호선] { 부개 }  게이트 외부 / 맞이방(남쪽방향) ");
        list.add("[1호선] { 부평 }  게이트 외부 / 맞이방2번출구쪽 ");
        list.add("[1호선] { 백운 }  게이트 외부 / 1번 출구 ");
        list.add("[1호선] { 동암 }  게이트 외부 / 1번 출구 ");
        list.add("[1호선] { 간석 }  게이트 내부 / 상행에스컬레이터옆 ");
        list.add("[1호선] { 주안 }  게이트 외부 / 1번출구방향왼편 ");
        list.add("[1호선] { 도화 }  게이트 외부 / 게이트나가서오른편 ");
        list.add("[1호선] { 제물포 }  게이트 외부 / 1번 출구 ");
        list.add("[1호선] { 도원 }  게이트 내부 / 4번인천방면(타는곳) ");
        list.add("[1호선] { 동인천 }  게이트 외부 / 1번출구 ");
        list.add("[1호선] { 인천 }  게이트 외부 / 역무실앞 ");
        list.add("[1호선] { 가산디지털단지 }  게이트 외부 / 맞이방 ");
        list.add("[1호선] { 독산 }  게이트 외부 / 1번 출구 ");
        list.add("[1호선] { 금천구청 }  게이트 외부 / 1번출구계단내려가서우측 ");
        list.add("[1호선] { 석수 }  게이트 내부 / 하행승강장1-1앞 ");
        list.add("[1호선] { 관악 }  게이트 내부 / 하행승강장E/V타는방면 ");
        list.add("[1호선] { 안양 }  게이트 외부 / 남쪽게이트나와서우측방향 ");
        list.add("[1호선] { 명학 }  게이트 외부 / 역사맞이방(1,2) ");
        list.add("[1호선] { 금정 }  게이트 외부 / 남쪽역사맞이방(1,2,3,4,5) ");
        list.add("[1호선] { 군포 }  게이트 외부 / 1번출구 ");
        list.add("[1호선] { 당정 }  게이트 외부 / 1번출구 ");
        list.add("[1호선] { 의왕 }  게이트 외부 / 맞이방1.2번출구사이 ");
        list.add("[1호선] { 성균관대 }  게이트 외부 / 상선계단입구뒤쪽(2번출구) ");
        list.add("[1호선] { 화서 }  게이트 내부 / 2,3번출구방향 ");
        list.add("[1호선] { 수원 }  게이트 외부 / 2번출구(서편) ");
        list.add("[1호선] { 세류 }  게이트 외부 / 1번출구 ");
        list.add("[1호선] { 병점 }  게이트 외부 / 1번출구자유통로 ");
        list.add("[1호선] { 세마 }  게이트 외부 / 1번출구방향왼쪽(남,여) ");
        list.add("[1호선] { 오산대 }  게이트 외부 / 게이트외부,대합실내 ");
        list.add("[1호선] { 오산 }  게이트 외부 / 1번출구옆 ");
        list.add("[1호선] { 진위 }  게이트 외부 / 2층1번출구 ");
        list.add("[1호선] { 송탄 }  게이트 정보없음 / 정보없음 ");
        list.add("[1호선] { 서정리 }  게이트 외부 / 1번출구방향 ");
        list.add("[1호선] { 지제 }  게이트 외부 / 맞이방 ");
        list.add("[1호선] { 평택 }  게이트 정보없음 / 정보없음 ");
        list.add("[1호선] { 성환 }  게이트 외부 / 맞이방반대편좌측 ");
        list.add("[1호선] { 직산 }  게이트 외부 / 1번출구 ");
        list.add("[1호선] { 두정 }  게이트 외부 / 1번출구좌측 ");
        list.add("[1호선] { 천안 }  게이트 외부 / 우측 ");
        list.add("[1호선] { 봉명 }  게이트 외부 / 게이트방향우측 ");
        list.add("[1호선] { 쌍용(나사렛대) }  게이트 외부 / 1번 출구 ");
        list.add("[1호선] { 아산 }  게이트 외부 / 1번출입구좌측 ");
        list.add("[1호선] { 배방 }  게이트 외부 / 1번출입구좌측 ");
        list.add("[1호선] { 온양온천 }  게이트 외부 / 2번출입구맞이방내 ");
        list.add("[1호선] { 신창(순천향대) }  게이트 외부 / 1번 출구 ");
        list.add("[1호선] { 광명 }  게이트 정보없음 / 정보없음 ");
        list.add("[1호선] { 서동탄 }  게이트 정보없음 / 정보없음 ");
        list.add("[1호선] { 청량리(서울시립대입구) }  게이트 외부 / 4번출입구 ");
        list.add("[1호선] { 제기동 }  게이트 외부 / 2번출입구 ");
        list.add("[1호선] { 신설동 }  게이트 외부 / 1번출입구 ");
        list.add("[1호선] { 동묘앞 }  게이트 외부 / 2번출입구 ");
        list.add("[1호선] { 동대문 }  게이트 외부 / 4번출입구 ");
        list.add("[1호선] { 종로5가 }  게이트 외부 / 8번출입구 ");
        list.add("[1호선] { 종로3가 }  게이트 외부 / 1,2번출입구 ");
        list.add("[1호선] { 종각 }  게이트 외부 / 1번출입구 ");
        list.add("[1호선] { 시청 }  게이트 외부 / 5번출입구 ");
        list.add("[1호선] { 서울역 }  게이트 정보없음 / 정보없음 ");


        list.add("[2호선] { 시청 }  게이트 내부 / 8번출입구 ");
        list.add("[2호선] { 을지로입구 }  게이트 외부 / 5번출입구 ");
        list.add("[2호선] { 을지로3가 }  게이트 외부 / 2,11번 출입구 ");
        list.add("[2호선] { 을지로4가 }  게이트 정보없음 / 정보없음 ");
        list.add("[2호선] { 동대문역사문화공원 }  게이트 정보없음 / 정보없음 ");
        list.add("[2호선] { 신당 }  게이트 외부 / 1,4번 출입구 ");
        list.add("[2호선] { 상왕십리 }  게이트 외부 / 5번 출입구 ");
        list.add("[2호선] { 왕십리 }  게이트 외부 / 6-1번 출입구 ");
        list.add("[2호선] { 한양대 }  게이트 외부 / 2번 출입구 ");
        list.add("[2호선] { 뚝섬 }  게이트 외부 / 대합실중앙 (각 출입구에서 102m 거리) ");
        list.add("[2호선] { 성수 }  게이트 외부 / 2번출입구 ");
        list.add("[2호선] { 건대입구 }  게이트 내부 / 대합실중앙 ");
        list.add("[2호선] { 구의(광진구청) }  게이트 외부 / 2번3번,출입구 방향 ");
        list.add("[2호선] { 강변(동서울터미널) }  게이트 외부 / 1번출입구 ");
        list.add("[2호선] { 잠실나루 }  게이트 외부 / 2번출입구 ");
        list.add("[2호선] { 잠실(송파구청) }  게이트 정보없음 / 정보없음 ");
        list.add("[2호선] { 잠실새내 }  게이트 외부 / 2번,7번출입구 ");
        list.add("[2호선] { 종합운동장 }  게이트 외부 / 1번출입구 ");
        list.add("[2호선] { 삼성(무역센터) }  게이트 정보없음 / 정보없음 ");
        list.add("[2호선] { 선릉 }  게이트 외부 / 1번출입구 ");
        list.add("[2호선] { 역삼 }  게이트 외부 / 3,4번 출입구 ");
        list.add("[2호선] { 강남 }  게이트 내부 / 1번,12번출입구 ");
        list.add("[2호선] { 교대(법원·검찰청) }  게이트 외부 / 1번출입구 ");
        list.add("[2호선] { 서초 }  게이트 외부 / 1,2,7,8번출입구 ");
        list.add("[2호선] { 방배 }  게이트 외부 / 1,4번출구 ");
        list.add("[2호선] { 사당 }  게이트 외부 / 1번출입구 ");
        list.add("[2호선] { 낙성대 }  게이트 외부 / 4,5번출구 ");
        list.add("[2호선] { 서울대입구(관악구청) }  게이트 외부 / 8번출입구 ");
        list.add("[2호선] { 봉천 }  게이트 외부 / 2번출구 ");
        list.add("[2호선] { 신림 }  게이트 내부 / 4번출구 ");
        list.add("[2호선] { 신대방 }  게이트 내부 / 1번출구 ");
        list.add("[2호선] { 구로디지털단지 }  게이트 내부 / 2,3번출구 ");
        list.add("[2호선] { 대림(구로구청) }  게이트 정보없음 / 정보없음 ");
        list.add("[2호선] { 신도림 }  게이트 내부 / 1번 출입구 ");
        list.add("[2호선] { 문래 }  게이트 외부 / 2,3번 출입구 ");
        list.add("[2호선] { 영등포구청 }  게이트 내부 / 2번 출입구 ");
        list.add("[2호선] { 당산 }  게이트 내부 / 3,4번 출입구 ");
        list.add("[2호선] { 합정 }  게이트 외부 / 1.2.3.4번출입구 ");
        list.add("[2호선] { 홍대입구 }  게이트 외부 / 2번출입구 ");
        list.add("[2호선] { 신촌 }  게이트 외부 / 5,6번출입구 ");
        list.add("[2호선] { 이대 }  게이트 외부 / 5번출입구 ");
        list.add("[2호선] { 아현 }  게이트 외부 / 1번출입구(남자화장실) ");
        list.add("[2호선] { 충정로(경기대입구) }  게이트 외부 / 6번출입구 ");
        list.add("[2호선] { 용답 }  게이트 외부 / 1번 출구 ");
        list.add("[2호선] { 신답 }  게이트 정보없음 / 정보없음 ");
        list.add("[2호선] { 용두(동대문구청) }  게이트 내부 / 1번 출구 ");
        list.add("[2호선] { 신설동 }  게이트 내부 / 1번 출구 ");
        list.add("[2호선] { 도림천 }  게이트 외부 / 1번 출구 ");
        list.add("[2호선] { 양천구청 }  게이트 내부 / 1번 출구 ");
        list.add("[2호선] { 신정네거리 }  게이트 외부 / 1번 출구 ");
        list.add("[2호선] { 까치산 }  게이트 정보없음 / 정보없음 ");


        list.add("[3호선] { 대화 }  게이트 외부 / 2번과3번출구사이 ");
        list.add("[3호선] { 주엽 }  게이트 외부 / 2번출구와3번출구사이 ");
        list.add("[3호선] { 정발산 }  게이트 외부 / 2번출구근접 ");
        list.add("[3호선] { 마두 }  게이트 외부 / 3번출구 ");
        list.add("[3호선] { 백석 }  게이트 외부 / 3,4번출구옆 ");
        list.add("[3호선] { 대곡 }  게이트 외부 / 1층5번출구(엘리베이터뒤) ");
        list.add("[3호선] { 화정 }  게이트 외부 / 4번출구 ");
        list.add("[3호선] { 원당 }  게이트 외부 / 5,6번출구방향 ");
        list.add("[3호선] { 원흥 }  게이트 외부 / 4번 출구와 6번 출구 사이 ");
        list.add("[3호선] { 삼송 }  게이트 외부 / 1.2번출구에서북쪽으로50m ");
        list.add("[3호선] { 지축 }  게이트 내부 / 2번출입구 ");
        list.add("[3호선] { 구파발 }  게이트 정보없음 / 정보없음 ");
        list.add("[3호선] { 연신내 }  게이트 내부 / 3번출입구 ");
        list.add("[3호선] { 불광 }  게이트 외부 / 3번출입구 ");
        list.add("[3호선] { 녹번 }  게이트 외부 / 4,5번출입구 ");
        list.add("[3호선] { 홍제 }  게이트 외부 / 2번출입구 ");
        list.add("[3호선] { 무악재 }  게이트 정보없음 / 정보없음 ");
        list.add("[3호선] { 독립문 }  게이트 내부 / 4번출입구 ");
        list.add("[3호선] { 경복궁(정부서울청사) }  게이트 내부 / 1,2,3,3-1,7번출입구 ");
        list.add("[3호선] { 안국 }  게이트 외부 / 2,3,4,5번 출입구 ");
        list.add("[3호선] { 종로3가 }  게이트 내부 / 7,8번출입구 ");
        list.add("[3호선] { 을지로3가 }  게이트 내부 / 3,4,5,6번 출입구 ");
        list.add("[3호선] { 충무로 }  게이트 내부 / 1번 출구 ");
        list.add("[3호선] { 동대입구 }  게이트 내부 / 6번출입구 ");
        list.add("[3호선] { 약수 }  게이트 내부 / 3번출입구 ");
        list.add("[3호선] { 금호 }  게이트 내부 / 1번출입구 ");
        list.add("[3호선] { 옥수 }  게이트 내부 / 3번 출입구 ");
        list.add("[3호선] { 압구정 }  게이트 외부 / 5번출입구 ");
        list.add("[3호선] { 신사 }  게이트 외부 / 2번출입구 ");
        list.add("[3호선] { 잠원 }  게이트 내부 / 4번출입구 ");
        list.add("[3호선] { 고속터미널 }  게이트 정보없음 / 정보없음 ");
        list.add("[3호선] { 교대(법원·검찰청) }  게이트 외부 / 14번출입구 ");
        list.add("[3호선] { 남부터미널(예술의전당) }  게이트 내부 / 1번출입구 ");
        list.add("[3호선] { 양재(서초구청) }  게이트 내부 / 4번출입구 ");
        list.add("[3호선] { 매봉 }  게이트 정보없음 / 정보없음 ");
        list.add("[3호선] { 도곡 }  게이트 외부 / 4번출구 ");
        list.add("[3호선] { 대치 }  게이트 정보없음 / 정보없음 ");
        list.add("[3호선] { 학여울 }  게이트 외부 / 1번출구 ");
        list.add("[3호선] { 대청 }  게이트 내부 / 4번출구 ");
        list.add("[3호선] { 일원 }  게이트 외부 / 7번출구 ");
        list.add("[3호선] { 수서 }  게이트 내부 / 3번출구 ");
        list.add("[3호선] { 가락시장 }  게이트 내부 / 7번출구 ");
        list.add("[3호선] { 경찰병원 }  게이트 정보없음 / 정보없음 ");
        list.add("[3호선] { 오금 }  게이트 내부 / 2번출구 ");

        list.add("[4호선] { 당고개 }  게이트 외부 / 1번출구EV에서60미터 ");
        list.add("[4호선] { 상계 }  게이트 외부 / 1번출구EV에서70미터 ");
        list.add("[4호선] { 노원 }  게이트 외부 / 2번출구앞 ");
        list.add("[4호선] { 창동 }  게이트 내부 / 북쪽게이트안쪽약30M ");
        list.add("[4호선] { 쌍문 }  게이트 내부 / 남쪽게이트안쪽약30M ");
        list.add("[4호선] { 수유(강북구청) }  게이트 외부 / 2,3 ");
        list.add("[4호선] { 미아 }  게이트 외부 / 3,4번출구통로 ");
        list.add("[4호선] { 미아사거리 }  게이트 외부 / 4-1출구방향 ");
        list.add("[4호선] { 길음 }  게이트 내부 / 1번 출구 ");
        list.add("[4호선] { 성신여대입구(돈암) }  게이트 외부 / 맞이방 ");
        list.add("[4호선] { 한성대입구(삼선교) }  게이트 외부 / 맞이방 ");
        list.add("[4호선] { 혜화 }  게이트 정보없음 / 정보없음 ");
        list.add("[4호선] { 동대문 }  게이트 정보없음 / 정보없음 ");
        list.add("[4호선] { 동대문역사문화공원 }  게이트 외부 / 맞이방 ");
        list.add("[4호선] { 충무로 }  게이트 내부 / 출구방향오른쪽 ");
        list.add("[4호선] { 명동 }  게이트 내부 / 1번 출구 ");
        list.add("[4호선] { 회현(남대문시장) }  게이트 내부 / 1층맞이방게이트내위치 ");
        list.add("[4호선] { 서울역 }  게이트 내부 / 1번출구 ");
        list.add("[4호선] { 숙대입구(갈월) }  게이트 외부 / 1번출구 ");
        list.add("[4호선] { 삼각지 }  게이트 외부 / 2번출구방향 ");
        list.add("[4호선] { 신용산 }  게이트 외부 / 2번출구좌측20M ");
        list.add("[4호선] { 이촌(국립중앙박물관) }  게이트 외부 / 1,2번출구우측20M ");
        list.add("[4호선] { 당고개 }  게이트 외부 / 1, 4번출입구 ");
        list.add("[4호선] { 상계 }  게이트 내부 / 4번출입구 ");
        list.add("[4호선] { 노원 }  게이트 내부 / 2, 9번 출입구 ");
        list.add("[4호선] { 창동 }  게이트 정보없음 / 정보없음 ");
        list.add("[4호선] { 쌍문 }  게이트 정보없음 / 정보없음 ");
        list.add("[4호선] { 수유(강북구청) }  게이트 외부 / 2번 출입구 ");
        list.add("[4호선] { 미아 }  게이트 정보없음 / 정보없음 ");
        list.add("[4호선] { 미아사거리 }  게이트 외부 / 1, 6번 출입구 ");
        list.add("[4호선] { 길음 }  게이트 외부 / 5번출입구 ");
        list.add("[4호선] { 성신여대입구(돈암) }  게이트 외부 / 4번출구 ");
        list.add("[4호선] { 한성대입구(삼선교) }  게이트 외부 / 1번출입구 ");
        list.add("[4호선] { 혜화 }  게이트 외부 / 3번출입구 ");
        list.add("[4호선] { 동대문 }  게이트 내부 / 9번출입구 ");
        list.add("[4호선] { 동대문역사문화공원 }  게이트 외부 / 1번출입구 ");
        list.add("[4호선] { 충무로 }  게이트 내부 / 3,4,5,6,7출입구 ");
        list.add("[4호선] { 명동 }  게이트 내부 / 4,5,6번 출입구 ");
        list.add("[4호선] { 회현(남대문시장) }  게이트 내부 / 3,4,5번 출입구 ");
        list.add("[4호선] { 서울역 }  게이트 외부 / 10번출입구(남자전용) ");
        list.add("[4호선] { 숙대입구(갈월) }  게이트 외부 / 대합실 중간 ");
        list.add("[4호선] { 삼각지 }  게이트 내부 / 3,4번출입구 ");
        list.add("[4호선] { 신용산 }  게이트 외부 / 5,6번출입구 ");
        list.add("[4호선] { 이촌(국립중앙박물관) }  게이트 내부 / 3번출입구 ");
        list.add("[4호선] { 동작(현충원) }  게이트 내부 / 1번출입구 ");
        list.add("[4호선] { 총신대입구(이수) }  게이트 내부 / 1번, 14번출입구 ");
        list.add("[4호선] { 사당 }  게이트 정보없음 / 정보없음 ");
        list.add("[4호선] { 남태령 }  게이트 내부 / 2번출입구 ");

        list.add("[5호선] { 방화 }  게이트 정보없음 / 정보없음 ");
        list.add("[5호선] { 개화산 }  게이트 외부 / 1,2번출구 ");
        list.add("[5호선] { 김포공항 }  게이트 외부 / 1번출구 ");
        list.add("[5호선] { 송정 }  게이트 외부 / 1,2번출구 ");
        list.add("[5호선] { 마곡 }  게이트 정보없음 / 정보없음 ");
        list.add("[5호선] { 발산 }  게이트 외부 / 1,9번출구 ");
        list.add("[5호선] { 우장산 }  게이트 외부 / 1, 2번출구와 3, 4번 출구로 갈라지는 길목의 안쪽 통로 ");
        list.add("[5호선] { 화곡 }  게이트 외부 / 7,8출구 ");
        list.add("[5호선] { 까치산 }  게이트 외부 / 4번 출구 ");
        list.add("[5호선] { 신정(은행정) }  게이트 내부 / 2, 3번출구 ");
        list.add("[5호선] { 목동 }  게이트 외부 / 7,8번 출구 ");
        list.add("[5호선] { 오목교(목동운동장앞) }  게이트 외부 / 3,4,5,6,7번출구 ");
        list.add("[5호선] { 양평 }  게이트 정보없음 / 정보없음 ");
        list.add("[5호선] { 영등포구청 }  게이트 외부 / 7번출구 앞 ");
        list.add("[5호선] { 영등포시장 }  게이트 외부 / 2, 3번출구 ");
        list.add("[5호선] { 신길 }  게이트 외부 / 1,2번출구 ");
        list.add("[5호선] { 여의도 }  게이트 외부 / 3번출구 ");
        list.add("[5호선] { 여의나루 }  게이트 정보없음 / 정보없음 ");
        list.add("[5호선] { 마포 }  게이트 외부 / 1번출구 ");
        list.add("[5호선] { 공덕 }  게이트 외부 / 3,4번 출구 ");
        list.add("[5호선] { 애오개 }  게이트 외부 / 3.4번출구 ");
        list.add("[5호선] { 충정로(경기대입구) }  게이트 외부 / 8,9번출구 ");
        list.add("[5호선] { 서대문 }  게이트 외부 / 2번출구 ");
        list.add("[5호선] { 광화문(세종문화회관) }  게이트 외부 / 1,8번출구 ");
        list.add("[5호선] { 종로3가(탑골공원) }  게이트 내부 / 광화문방면(4,5번 출구) ");
        list.add("[5호선] { 을지로4가 }  게이트 외부 / 2,5번 출구 ");
        list.add("[5호선] { 동대문역사문화공원 }  게이트 내부 / 6,7번출구 ");
        list.add("[5호선] { 청구 }  게이트 외부 / 2번출구 ");
        list.add("[5호선] { 신금호 }  게이트 내부 / 3번출구 ");
        list.add("[5호선] { 행당 }  게이트 외부 / 1,2,3,4번출구 ");
        list.add("[5호선] { 왕십리 }  게이트 내부 / 4,5번출구 ");
        list.add("[5호선] { 마장 }  게이트 외부 / 1,2,3,4번 출구 ");
        list.add("[5호선] { 답십리 }  게이트 정보없음 / 정보없음 ");
        list.add("[5호선] { 장한평 }  게이트 외부 / 1번출구 ");
        list.add("[5호선] { 군자(능동) }  게이트 외부 / 7번,8번출구 ");
        list.add("[5호선] { 아차산(어린이대공원후문) }  게이트 외부 / 3,4,5번출구 ");
        list.add("[5호선] { 광나루(장신대) }  게이트 외부 / 4번출구 ");
        list.add("[5호선] { 천호(풍납토성) }  게이트 외부 / 7,8번출구 ");
        list.add("[5호선] { 강동 }  게이트 외부 / 1,2번 출구 사이 ");
        list.add("[5호선] { 길동 }  게이트 외부 / 1,2번출구 ");
        list.add("[5호선] { 굽은다리(강동구민회관앞) }  게이트 외부 / 3번출구 ");
        list.add("[5호선] { 명일 }  게이트 외부 / B1층 3,4번출구 방향 ");
        list.add("[5호선] { 고덕 }  게이트 외부 / 1,2번출구 ");
        list.add("[5호선] { 상일동 }  게이트 외부 / 8번 출구 ");
        list.add("[5호선] { 강일 }  게이트 정보없음 / 정보없음 ");
        list.add("[5호선] { 미사 }  게이트 외부 / 1번 출입구 옆 ");
        list.add("[5호선] { 하남풍산 }  게이트 외부 / 3번 출입구 옆 ");
        list.add("[5호선] { 하남시청(덕풍·신장) }  게이트 정보없음 / 정보없음 ");
        list.add("[5호선] { 하남검산단역 }  게이트 정보없음 / 정보없음 ");
        list.add("[5호선] { 둔촌동 }  게이트 내부 / 3,4번출구 ");
        list.add("[5호선] { 올림픽공원(한국체대) }  게이트 외부 / 2번출구 ");
        list.add("[5호선] { 방이 }  게이트 외부 / 3,4출구 ");
        list.add("[5호선] { 오금 }  게이트 내부 / 1번 출구 ");
        list.add("[5호선] { 개롱 }  게이트 외부 / 1번출구 ");
        list.add("[5호선] { 거여 }  게이트 외부 / 7,8번출구 ");
        list.add("[5호선] { 마천 }  게이트 외부 / 지하1층 대합실 ");

        list.add("[6호선] { 응암 }  게이트 정보없음 / 정보없음 ");
        list.add("[6호선] { 역촌 }  게이트 외부 / 3,4번출구 방향 ");
        list.add("[6호선] { 불광 }  게이트 외부 / 가 역사 6-9 출구방향 가는 길 ");
        list.add("[6호선] { 독바위 }  게이트 외부 / 1번 출구 방향 ");
        list.add("[6호선] { 연신내 }  게이트 내부 / 3번출입구 ");
        list.add("[6호선] { 구산 }  게이트 정보없음 / 정보없음 ");
        list.add("[6호선] { 새절(신사) }  게이트 외부 / 1,2번 출구방향 ");
        list.add("[6호선] { 증산(명지대앞) }  게이트 외부 / 1,2번 출구방향 ");
        list.add("[6호선] { 디지털미디어시티 }  게이트 외부 / 1,5번 출구방향 ");
        list.add("[6호선] { 월드컵경기장(성산) }  게이트 외부 / 2,3번 출구방향 ");
        list.add("[6호선] { 마포구청 }  게이트 외부 / 1,2,8번 출구방향 ");
        list.add("[6호선] { 망원 }  게이트 외부 / 1번출구방향  ");
        list.add("[6호선] { 합정 }  게이트 외부 / 8번 출구방향 ");
        list.add("[6호선] { 상수 }  게이트 외부 / 3,4번 출구방향 ");
        list.add("[6호선] { 광흥창(서강) }  게이트 외부 / 1,2,5,6번 출구방향 ");
        list.add("[6호선] { 대흥(서강대앞) }  게이트 외부 / 3,4번 출구방향 ");
        list.add("[6호선] { 공덕 }  게이트 외부 / 3,4번 출구방향 ");
        list.add("[6호선] { 효창공원앞 }  게이트 외부 / 7,8번 출구방향 ");
        list.add("[6호선] { 삼각지 }  게이트 외부 / 1,2번 출구 ");
        list.add("[6호선] { 녹사평(용산구청) }  게이트 외부 / 1,2번출구 ");
        list.add("[6호선] { 이태원 }  게이트 외부 / 1번 출구 ");
        list.add("[6호선] { 한강진 }  게이트 내부 / 지하1층 게이트 안쪽에 위치 ");
        list.add("[6호선] { 버티고개 }  게이트 외부 / 1번출구 ");
        list.add("[6호선] { 약수 }  게이트 외부 / 7,8번출구 ");
        list.add("[6호선] { 청구 }  게이트 외부 / 2번출구 ");
        list.add("[6호선] { 신당 }  게이트 외부 / 5~9번출구 ");
        list.add("[6호선] { 동묘앞 }  게이트 외부 / 7번출구 ");
        list.add("[6호선] { 창신 }  게이트 내부 / 대합실 ");
        list.add("[6호선] { 보문 }  게이트 외부 / 5~8번 출구 ");
        list.add("[6호선] { 안암(고대병원앞) }  게이트 외부 / 3번출구 ");
        list.add("[6호선] { 고려대(종암) }  게이트 내부 / 하선 엘리베이트 옆 ");
        list.add("[6호선] { 월곡(동덕여대) }  게이트 외부 / 123번과 45번 중간 ");
        list.add("[6호선] { 상월곡(한국과학기술연구원) }  게이트 외부 / 1,4번출구 ");
        list.add("[6호선] { 돌곶이 }  게이트 정보없음 / 정보없음 ");
        list.add("[6호선] { 석계 }  게이트 외부 / 1,6,7번 출구 ");
        list.add("[6호선] { 태릉입구 }  게이트 외부 / 1번 출구 ");
        list.add("[6호선] { 화랑대(서울여대입구) }  게이트 외부 / 대합실(1~7번출구) ");
        list.add("[6호선] { 봉화산(서울의료원) }  게이트 외부 / 2,3번출구 ");
        list.add("[6호선] { 신내 }  게이트 외부 / 1번 출구 ");

        list.add("[7호선] { 장암 }  게이트 외부 / 1번출구 ");
        list.add("[7호선] { 도봉산 }  게이트 외부 / 2번출구 ");
        list.add("[7호선] { 수락산 }  게이트 외부 / 3번출구 ");
        list.add("[7호선] { 마들 }  게이트 외부 / 3,4,5,6번출구 ");
        list.add("[7호선] { 노원 }  게이트 외부 / 5,6번출구 ");
        list.add("[7호선] { 중계 }  게이트 외부 / 1,2번출구 ");
        list.add("[7호선] { 하계 }  게이트 외부 / 2-5번출구 ");
        list.add("[7호선] { 공릉(서울과학기술대) }  게이트 외부 / 1-4번 출구 ");
        list.add("[7호선] { 태릉입구 }  게이트 외부 / 1,6,7,8번 출구 ");
        list.add("[7호선] { 먹골 }  게이트 외부 / 1,2,7번출구 ");
        list.add("[7호선] { 중화 }  게이트 외부 / 2.3번출구 ");
        list.add("[7호선] { 상봉(시외버스터미널) }  게이트 내부 / 5번출구 ");
        list.add("[7호선] { 면목 }  게이트 외부 / 게이트 정면 ");
        list.add("[7호선] { 사가정 }  게이트 외부 / 1번출구 ");
        list.add("[7호선] { 용마산 }  게이트 외부 / 1번출구 ");
        list.add("[7호선] { 중곡 }  게이트 외부 / 1번출구 ");
        list.add("[7호선] { 군자(능동) }  게이트 외부 / 1.6번 출구 ");
        list.add("[7호선] { 어린이대공원(세종대) }  게이트 내부 / 4번출구 ");
        list.add("[7호선] { 건대입구 }  게이트 내부 / 1번 출구 ");
        list.add("[7호선] { 뚝섬유원지 }  게이트 정보없음 / 정보없음 ");
        list.add("[7호선] { 청담 }  게이트 외부 / 4~11번 출구방향 게이트 앞 ");
        list.add("[7호선] { 강남구청 }  게이트 정보없음 / 정보없음 ");
        list.add("[7호선] { 학동 }  게이트 정보없음 / 정보없음 ");
        list.add("[7호선] { 논현 }  게이트 외부 / 7,8번 출구 ");
        list.add("[7호선] { 반포 }  게이트 외부 / 1번출구 ");
        list.add("[7호선] { 고속터미널 }  게이트 정보없음 / 정보없음 ");
        list.add("[7호선] { 내방 }  게이트 외부 / 5~8번 출구 ");
        list.add("[7호선] { 총신대입구(이수) }  게이트 외부 / 7,8번 출구방향 지하 2층 중앙통로  ");
        list.add("[7호선] { 남성 }  게이트 내부 / 아이센터 맞은편 ");
        list.add("[7호선] { 숭실대입구(살피재) }  게이트 외부 / 3번출구 ");
        list.add("[7호선] { 상도 }  게이트 외부 / 공통출구 ");
        list.add("[7호선] { 장승배기 }  게이트 외부 / 5,6번출구 ");
        list.add("[7호선] { 신대방삼거리 }  게이트 정보없음 / 정보없음 ");
        list.add("[7호선] { 보라매 }  게이트 정보없음 / 정보없음 ");
        list.add("[7호선] { 신풍 }  게이트 외부 / 5번출구 ");
        list.add("[7호선] { 대림(구로구청) }  게이트 외부 / 9,10번출구 ");
        list.add("[7호선] { 남구로 }  게이트 정보없음 / 정보없음 ");
        list.add("[7호선] { 가산디지털단지 }  게이트 정보없음 / 정보없음 ");
        list.add("[7호선] { 철산 }  게이트 외부 / 3번출구 ");
        list.add("[7호선] { 광명사거리 }  게이트 외부 / 1번~10번 출구 ");
        list.add("[7호선] { 천왕 }  게이트 외부 / 2번출구 ");
        list.add("[7호선] { 온수(성공회대입구) }  게이트 외부 / 2번출구 ");
        list.add("[7호선] { 까치울 }  게이트 외부 / 5번출구 ");
        list.add("[7호선] { 부천종합운동장 }  게이트 내부 / 3번, 5번출구 ");
        list.add("[7호선] { 춘의 }  게이트 외부 / 2,3번출구사이 ");
        list.add("[7호선] { 신중동 }  게이트 외부 / 6번출구 ");
        list.add("[7호선] { 부천시청 }  게이트 외부 / 3번출구 ");
        list.add("[7호선] { 상동 }  게이트 외부 / 3번출구 ");
        list.add("[7호선] { 삼산체육관 }  게이트 외부 / 1번출구 ");
        list.add("[7호선] { 굴포천 }  게이트 외부 / 5번출구 ");
        list.add("[7호선] { 부평구청 }  게이트 내부 / 3번출구 ");

        list.add("[8호선] { 암사 }  게이트 외부 / 2번출구 ");
        list.add("[8호선] { 천호(풍납토성) }  게이트 외부 / 7 ");
        list.add("[8호선] { 강동구청 }  게이트 외부 / 2번출구 ");
        list.add("[8호선] { 몽촌토성(평화의문) }  게이트 외부 / 1번출구 ");
        list.add("[8호선] { 잠실(송파구청) }  게이트 외부 / 10,11번출구 ");
        list.add("[8호선] { 석촌 }  게이트 외부 / 8번 출구 ");
        list.add("[8호선] { 송파 }  게이트 외부 / 1,2번출구 ");
        list.add("[8호선] { 가락시장 }  게이트 외부 / 2번 출구 ");
        list.add("[8호선] { 문정 }  게이트 내부 / 1,2번 출구 ");
        list.add("[8호선] { 장지 }  게이트 외부 / 4번 출구 ");
        list.add("[8호선] { 복정 }  게이트 외부 / 1,2,3,4번출구 ");
        list.add("[8호선] { 산성 }  게이트 정보없음 / 정보없음 ");
        list.add("[8호선] { 남한산성입구(성남법원·검찰청) }  게이트 정보없음 / 정보없음 ");
        list.add("[8호선] { 단대오거리 }  게이트 외부 / 1,2,3,4번 출구 (내부E/S옆) ");
        list.add("[8호선] { 신흥 }  게이트 외부 / 4번출구 ");
        list.add("[8호선] { 수진 }  게이트 외부 / 1,2번출구  ");
        list.add("[8호선] { 모란 }  게이트 외부 / 1,2번 출구 ");

        list.add("[9호선] { 개화 }  게이트 외부 / 2번 출입구 ");
        list.add("[9호선] { 김포공항 }  게이트 외부 / 4번 출입구 ");
        list.add("[9호선] { 공항시장 }  게이트 외부 / 4번출구 ");
        list.add("[9호선] { 신방화 }  게이트 외부 / 3번출구 ");
        list.add("[9호선] { 마곡나루 }  게이트 외부 / 2번 출구 ");
        list.add("[9호선] { 양천향교 }  게이트 외부 / 3번 출입구 ");
        list.add("[9호선] { 가양 }  게이트 외부 / 3번출입구 ");
        list.add("[9호선] { 증미 }  게이트 외부 / 1번 출입구 ");
        list.add("[9호선] { 등촌 }  게이트 외부 / 2번 출입구 ");
        list.add("[9호선] { 염창 }  게이트 외부 / 4번출입구 ");
        list.add("[9호선] { 신목동 }  게이트 외부 / 2번출입구 ");
        list.add("[9호선] { 선유도 }  게이트 외부 / 7번출구 ");
        list.add("[9호선] { 당산 }  게이트 내부 / 7번출구 ");
        list.add("[9호선] { 국회의사당 }  게이트 내부 / 3번 출구 E/S 내려온 후 좌측 50M(게이트통과) ");
        list.add("[9호선] { 여의도 }  게이트 외부 / 4번출구 ");
        list.add("[9호선] { 샛강 }  게이트 외부 / 1~4번 출구 ");
        list.add("[9호선] { 노량진 }  게이트 외부 / 3번 출구 ");
        list.add("[9호선] { 노들 }  게이트 외부 / 2번 출구 ");
        list.add("[9호선] { 흑석(중앙대입구) }  게이트 외부 / 1번출구 ");
        list.add("[9호선] { 동작(현충원) }  게이트 외부 / 9번출구 ");
        list.add("[9호선] { 구반포 }  게이트 외부 / 2번출입구 ");
        list.add("[9호선] { 신반포 }  게이트 외부 / 4번출입구 ");
        list.add("[9호선] { 고속터미널 }  게이트 외부 / 8-1번출구 ");
        list.add("[9호선] { 사평 }  게이트 외부 / 1번출입구 ");
        list.add("[9호선] { 신논현 }  게이트 외부 / 5번출입구 ");
        list.add("[9호선] { 언주 }  게이트 외부 / 2번 출구 근처 E/V 하차 후 좌측으로 20M  ");
        list.add("[9호선] { 선정릉 }  게이트 외부 / 3번출구 옆 ");
        list.add("[9호선] { 삼성중앙 }  게이트 외부 / 5번출구 ");
        list.add("[9호선] { 봉은사 }  게이트 외부 / 2번출구 ");
        list.add("[9호선] { 종합운동장 }  게이트 외부 / 지하 1층 대합실 9번 출입구 방향 ");
        list.add("[9호선] { 삼전 }  게이트 외부 / 3, 4번 출입구 사이 ");
        list.add("[9호선] { 석촌고분 }  게이트 외부 / 지하 1층 대합실 3, 4번 출입구 사이 ");
        list.add("[9호선] { 석촌 }  게이트 내부 / 지하 2층 대합실 개찰구 내부 근처 ");
        list.add("[9호선] { 송파나루 }  게이트 외부 / 지하 1층 대합실 1, 2번 출입구 계단 옆 ");
        list.add("[9호선] { 한성백제 }  게이트 외부 / 지하 1층 대합실 1, 2번 출입구 사이 ");
        list.add("[9호선] { 올림픽공원(한국체대) }  게이트 외부 / 지하 1층 대합실 개찰구 근처 ");
        list.add("[9호선] { 둔촌오륜 }  게이트 외부 / 지하 1층 대합실 1, 2번 출입구 방향 ");
        list.add("[9호선] { 중앙보훈병원 }  게이트 외부 / 지하 1층 대합실 1번 출입구 방향 계단 옆 ");

        list.add("[ 경의중앙선 ] { 용산 }  게이트 외부 / 3번출구 ");
        list.add("[ 경의중앙선 ] { 이촌 }  게이트 내부 / 게이트 옆 ");
        list.add("[ 경의중앙선 ] { 서빙고 }  게이트 내부 / 하선승강장 계단밑(1번출구) ");
        list.add("[ 경의중앙선 ] { 한남 }  게이트 정보없음 / 정보없음 ");
        list.add("[ 경의중앙선 ] { 옥수 }  게이트 외부 / 1번 출구 ");
        list.add("[ 경의중앙선 ] { 응봉 }  게이트 내부 / 1번출구 ");
        list.add("[ 경의중앙선 ] { 왕십리 }  게이트 외부 / 12,13번 출구 ");
        list.add("[ 경의중앙선 ] { 청량리 }  게이트 외부 / 1번 출구방향 ");
        list.add("[ 경의중앙선 ] { 회기 }  게이트 외부 / 1번출구 ");
        list.add("[ 경의중앙선 ] { 중랑 }  게이트 외부 / 3번출구 ");
        list.add("[ 경의중앙선 ] { 상봉 }  게이트 내부 / 1번 출구 ");
        list.add("[ 경의중앙선 ] { 망우 }  게이트 외부 / 1번출구 ");
        list.add("[ 경의중앙선 ] { 양원(서울시북부병원) }  게이트 외부 / 2번출구 ");
        list.add("[ 경의중앙선 ] { 구리 }  게이트 외부 / 1번출구 ");
        list.add("[ 경의중앙선 ] { 도농 }  게이트 외부 / 2번출구 ");
        list.add("[ 경의중앙선 ] { 양정 }  게이트 외부 / 맞이방 ");
        list.add("[ 경의중앙선 ] { 덕소 }  게이트 외부 / 1번출구 ");
        list.add("[ 경의중앙선 ] { 도심 }  게이트 외부 / 1번출구 ");
        list.add("[ 경의중앙선 ] { 팔당 }  게이트 외부 / 1번출구 ");
        list.add("[ 경의중앙선 ] { 운길산 }  게이트 외부 / 2번출구 ");
        list.add("[ 경의중앙선 ] { 양수 }  게이트 외부 / 1번출구 ");
        list.add("[ 경의중앙선 ] { 신원 }  게이트 외부 / 1번출구 ");
        list.add("[ 경의중앙선 ] { 국수 }  게이트 정보없음 / 정보없음 ");
        list.add("[ 경의중앙선 ] { 아신(아세아연합신학대) }  게이트 외부 / 1번출구 ");
        list.add("[ 경의중앙선 ] { 오빈 }  게이트 외부 / 자동발매기 옆 통로변(1번출구) ");
        list.add("[ 경의중앙선 ] { 양평 }  게이트 외부 / 1번출구 ");
        list.add("[ 경의중앙선 ] { 원덕(추읍산) }  게이트 외부 / 1번출구 ");
        list.add("[ 경의중앙선 ] { 용문 }  게이트 외부 / 1번출구 ");
        list.add("[ 경의중앙선 ] { 지평 }  게이트 외부 / 1번 출구 ");
        list.add("[ 경의중앙선 ] { 효창공원앞 }  게이트 외부 / 1번 출구 ");
        list.add("[ 경의중앙선 ] { 공덕 }  게이트 외부 / 10번출구(EV옆) ");
        list.add("[ 경의중앙선 ] { 서강대 }  게이트 외부 / 1.2번출구 맞이방 중앙 ");
        list.add("[ 경의중앙선 ] { 홍대입구 }  게이트 외부 / 맞이방내 고객지원실 전면 ");
        list.add("[ 경의중앙선 ] { 가좌 }  게이트 외부 / 지하1층 맞이방 자동발매기옆(2번출구방향) ");
        list.add("[ 경의중앙선 ] { 디지털미디어시티 }  게이트 외부 / 2층 역사내 ");
        list.add("[ 경의중앙선 ] { 수색 }  게이트 외부 / 맞이방 1번출구 바로 옆 ");
        list.add("[ 경의중앙선 ] { 화전(한국항공대) }  게이트 외부 / 맞이방 내 수유방 옆(1번출구) ");
        list.add("[ 경의중앙선 ] { 강매 }  게이트 외부 / 1번출구 맞이방 우측 10m ");
        list.add("[ 경의중앙선 ] { 행신 }  게이트 외부 / 맞이방(1,2번출구)스토리웨이옆 ");
        list.add("[ 경의중앙선 ] { 능곡 }  게이트 외부 / 맞이방에서 나가는 곳 오른쪽 ");
        list.add("[ 경의중앙선 ] { 대곡 }  게이트 내부 / 이동통로스토리웨이옆 ");
        list.add("[ 경의중앙선 ] { 곡산 }  게이트 외부 / 2층 통로 1번출입구 쪽 ");
        list.add("[ 경의중앙선 ] { 백마 }  게이트 외부 / 2번출구 방향 ");
        list.add("[ 경의중앙선 ] { 풍산 }  게이트 외부 / 2번출구 나가기 전 오른쪽 ");
        list.add("[ 경의중앙선 ] { 일산 }  게이트 외부 / 1번출구 ");
        list.add("[ 경의중앙선 ] { 탄현 }  게이트 외부 / 1번 출입구 옆 ");
        list.add("[ 경의중앙선 ] { 야당 }  게이트 외부 / 1,2번 출구방향 ");
        list.add("[ 경의중앙선 ] { 운정 }  게이트 외부 / 2번출구 나가긴전 왼쪽 ");
        list.add("[ 경의중앙선 ] { 금릉 }  게이트 외부 / 1,2번출구 중간 ");
        list.add("[ 경의중앙선 ] { 금촌 }  게이트 외부 / 1번출구 방향 오른쪽 ");
        list.add("[ 경의중앙선 ] { 월롱(서영대학교) }  게이트 외부 / 2번 출구 방향 오른쪽 ");
        list.add("[ 경의중앙선 ] { 파주(두원대학) }  게이트 외부 / 1번출구 나가기 전 왼쪽 ");
        list.add("[ 경의중앙선 ] { 문산 }  게이트 정보없음 / 정보없음 ");
        list.add("[ 경의중앙선 ] { 임진강 }  게이트 정보없음 / 정보없음 ");
        list.add("[ 경의중앙선 ] { 서울역 }  게이트 정보없음 / 정보없음 ");
        list.add("[ 경의중앙선 ] { 신촌 }  게이트 정보없음 / 정보없음 ");

        list.add("[ 신분당선 ] { 강남 }  게이트 외부 / 6번출구 ");
        list.add("[ 신분당선 ] { 양재(서초구청) }  게이트 외부 / 7번출구 ");
        list.add("[ 신분당선 ] { 양재시민의숲(매헌) }  게이트 외부 / 외부출구 ");
        list.add("[ 신분당선 ] { 청계산입구 }  게이트 외부 / 대합실 ");
        list.add("[ 신분당선 ] { 판교(판교테크노밸리) }  게이트 외부 / 1번 출입구 근처 ");
        list.add("[ 신분당선 ] { 정자 }  게이트 외부 / 대합실 ");
        list.add("[ 신분당선 ] { 미금(분당서울대병원) }  게이트 외부 / 6/7번 출입구 대합실 끝 ");
        list.add("[ 신분당선 ] { 동천 }  게이트 외부 / 2,3번출구 ");
        list.add("[ 신분당선 ] { 수지구청 }  게이트 외부 / 대합실 ");
        list.add("[ 신분당선 ] { 성복 }  게이트 외부 / 1,2,3번출구 ");
        list.add("[ 신분당선 ] { 상현 }  게이트 외부 / 대합실 ");
        list.add("[ 신분당선 ] { 광교중앙(아주대) }  게이트 외부 / 4번출구 ");
        list.add("[ 신분당선 ] { 광교(경기대) }  게이트 외부 / 1번출구 ");
    }


}
