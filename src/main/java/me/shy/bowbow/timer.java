package me.shy.bowbow;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class timer {
    private static BukkitTask timer;   // BukkitTask 타입의  timer 변수 선언 - 타이머 작업 관리
    public static int time;     // time 변수 선언 - 타이머가 경과한 틱 저장
    public static void timerStart(){   // 타이머 시작
        timer =  new BukkitRunnable(){  // 새로운 BukkitRunnable 객체를 생성, timer 에 할당

            @Override
            public void run() { // run 메서드를 매 틱마다 실행, time 변수를 증가시켜 경과한 틱을 기록
                ++time;
            }
        }.runTaskTimer(Bowbow.plugin, 0L, 1L);  // runTaskTimer 메서드는 BukkitRunnable 를 일정 간격으로 실행시킨다
    }                                                       // 플러그인 인스턴스, 지연시간, 반복주기 -> 현재는 매 틱마다 실행
    public void timerEnd(Player player){                    // 타이머를 종료하는 메서드
        if (!timer.isCancelled() && timer != null){         // 타이머가 실행 중인지, 타이머가 null 값인지 확인
            timer.cancel();                                 // 실행 중이라면 타이머를 취소
            timer = null;                                   // timer 변수를 null 로 설정
        }
        player.sendMessage("게임 시간 : " + time / 20 + "초");   // 플레이어에게 시간 출력
        time = 0;   // 시간 0으로 초기화
    }
}
