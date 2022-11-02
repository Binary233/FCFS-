/**
 * Created by 沈宇辰 on 10/23/22.
 */

import java.util.Scanner;

public class FCFS {
    public static void main(String[] args) {

        System.out.println("请输入进程数：");
        Scanner in = new Scanner(System.in);
        int numberOfProcesses = in.nextInt();

        int[] pid = new int[numberOfProcesses];
        int[] bt = new int[numberOfProcesses];
        int[] ar = new int[numberOfProcesses];
        int[] ct = new int[numberOfProcesses];
        int[] ta = new int[numberOfProcesses];
        int[] wt = new int[numberOfProcesses];
        int[] st = new int[numberOfProcesses];
        double[] wr = new double[numberOfProcesses];

        for(int i = 0; i < numberOfProcesses; i++) {
            System.out.println("进程" + (i+1) + "到达时间");
            ar[i] = in.nextInt();
            System.out.println("进程" + (i+1) + "服务时间");
            bt[i] = in.nextInt();
            pid[i] = i+1;
        }
        int temp;
        for (int i = 0; i < numberOfProcesses; i++) {
            for (int j = i+1; j < numberOfProcesses; j++) {

                if(ar[i] > ar[j]) {
                    temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;

                    temp = pid[i];
                    pid[i] = pid[j];
                    pid[j] = temp;
                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;
                }
            }
        }

        System.out.println();
        ct[0] = bt[0] + ar[0];
        for(int i = 1; i < numberOfProcesses; i++) {
            ct[i] = ct[i - 1] + bt[i];
        }
        for(int i = 0; i < numberOfProcesses; i++) {
            ta[i] = ct[i] - ar[i];
            wt[i] = ta[i] - bt[i];
        }
        for(int i = 0; i < numberOfProcesses; i++) {
            wr[i] = ta[i] / bt[i];
            st[i] = ta[i];
        }
        System.out.println("进程\t\t到达时间\t服务时间\t开始时间\t结束时间\t周转时间\t等待时间\t带权周转时间");
        for(int i = 0; i < numberOfProcesses; i++) {
            System.out.println(pid[i]+"\t\t" + ar[i] + "\t\t" + bt[i]+ "\t\t" + st[i]+ "\t\t" + ct[i]+ "\t\t" + ta[i]+ "\t\t" + wt[i]+ "\t\t" +String.format("%.2f", wr[i]));
        }
    }

}
