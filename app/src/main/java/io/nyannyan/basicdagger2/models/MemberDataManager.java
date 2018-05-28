package io.nyannyan.basicdagger2.models;

import android.content.SharedPreferences;
import java.util.ArrayList;

public class MemberDataManager {

  private String memberStatus = "Access Denied";
  private ArrayList<Member> members = new ArrayList<>();
  private SharedPreferences sharedPreferences;
  private static final String COUNT_KEYS = "count";
  private int currentCount;

  public MemberDataManager(SharedPreferences pref) {
    //Assign the pass Sp to this Sp
    sharedPreferences = pref;
    populateDate();
  }

  public MemberDataManager(SharedPreferences pref, NetworkManager networkManager) {
    //Assign the pass Sp to this Sp
    sharedPreferences = pref;
    populateDate();
  }

  public String checkMemberStatus(String userInput) {

    for (Member m: members) {

      if (m.getMemberId().equals(userInput)) {
        updateAccessCount();
        memberStatus = "Access Granted : Current count is " + getCurrentCount();
      }

    }

    return memberStatus;
  }

  private void updateAccessCount() {
    //Update the count by one and save it in Sp

    sharedPreferences.edit()
        .putInt(COUNT_KEYS, getCurrentCount()+1)
        .apply();

  }

  private void populateDate() {

    members.add(new Member("123", "Teo", "Teo123@gmial.com"));
    members.add(new Member("127", "Abu", "abu@gmial.com"));
    members.add(new Member("670", "Ali", "Ali@gmial.com"));
    members.add(new Member("230", "Nyan", "Nyan@gmial.com"));
    members.add(new Member("110", "chec", "chec@gmial.com"));
    members.add(new Member("602", "chek", "chek@gmial.com"));
    members.add(new Member("000", "neo", "neo@gmial.com"));

  }

  public int getCurrentCount() {
    //Get current count in Sp
    currentCount = sharedPreferences.getInt(COUNT_KEYS, 0);
    return currentCount;
  }
}
