package sys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		//入力された番号のList 
		List<Integer> getls = new ArrayList<>();
		//生徒の番号と名前のデータ取得
		Map<Integer,String> memlist = new TreeMap<>();
		memlist = member.members();
		//出欠した人のList
		List<Integer> aten = new ArrayList<>();
		//欠席した人のList
		List<Integer> ebs = new ArrayList<>();
		//繰り返し入力 ※00が入力されたら終了
		System.out.println("00で入力を終了\n フォームに入力された番号を入力してください");
		Scanner s = new java.util.Scanner(System.in);
		int number = 0;
		while(true) {
			try {
				int I = s.nextInt();
				getls.add(I);
			}catch(Exception e) {
				System.out.println("番号以外が入力されました。\n停止します。");
				return;
			}
				if( (getls.get(getls.size() - 1)) == 00 ) {
				System.out.println("All member of number get. It's OK");
				break;
			}else {		
				continue;
			}
		}
		//ソート用のクラスをインスタンス化 および昇順に並び替え
		Collections.sort(getls);
		System.out.println("sort complete");
		//重複を消去
		for(int i = 1; i < getls.size(); i++) {
			if(getls.get(i-1) == getls.get(i)) {
				getls.remove(i);
			}
		}
		//配列にgetlsを入れる、入っていない部分には0で初期化をする
		int ninzu = 47;//クラスの人数+1
		
		int[] getaly = new int[ninzu];
		for(int i = 0; i < ninzu; i++) {//繰り返しで配列に0を代入
			getaly[i] = 0;
		}
		for(int i = 0; i < ninzu; i++) {//配列に入力された番号を代入
			try {
			getaly[getls.get(i)] = getls.get(i);
			}catch(Exception e) {
				break;
			}
		}
		//出欠しているひとと欠席している人を分ける
		for(int i = 0; i < ninzu ; ++i) {
			if(getaly[i] == i) {
				aten.add(i);
			}else {
				ebs.add(i);
			}
		}
		System.out.println("欠席している方の番号と名前を表示します。");
		System.out.println("入力された人数は " + (getls.size()-1) + " です。");
		for(int a = ebs.size(), i = 0; i < a; i++) {
			System.out.println( ebs.get(i) + "	" + memlist.get(ebs.get(i)) );
		}
			
	}
}
