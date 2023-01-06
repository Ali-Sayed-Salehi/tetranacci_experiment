import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

  static long[] result = new long[6];
  static long[] elapsed = new long[6];

  // recording tetra numbers and times to executing them
  public static void tetraExperiment() {

    for (int i = 0; i<= 5; i++){
    long startTime = System.nanoTime( ); // record the starting time
    long tempResult = tetranacciBad(i*5);
    long endTime = System.nanoTime(); // record the ending time
    result[i] = tempResult;
    elapsed[i] = endTime - startTime; // compute the elapsed time

    }
  }

    // bad tetranacci recursive code
    public static long tetranacciBad(int n) {
    if (n <= 3) {
      return 0;
    } else if (n <= 4){
      return 1;
    } else {
      return (tetranacciBad(n-4) + tetranacciBad(n-3) + tetranacciBad(n-2) + tetranacciBad(n-1));
    }

    }


    

  public static void main(String[] args) {
  /*   long startTime = System.nanoTime( ); // record the starting time

    long[] result = tetranacciGood(25);

    long endTime = System.nanoTime(); // record the ending time
    long elapsed = endTime - startTime; // compute the elapsed time
*/
    tetraExperiment();
  //  System.out.println("Number is: " + result[5]);
  //  System.out.println("elapsed time is: " + elapsed[5]);

    // writing the results to a file
    try {
     
      BufferedWriter writer = new BufferedWriter(new FileWriter
      ("tetraBad_output.txt"));
      
      writer.write("index:\t\t\t\t1\t\t5\t\t10\t\t15\t\t20\t\t25\n");
      writer.write("Tetranacci numbers:");

      for (long num1 : result) {
        writer.write("\t\t" + num1);
      }

      writer.write("\n");
      writer.write("Time elapsed (ns):");

      for (long num2 : elapsed) {
        writer.write("\t\t" + num2);
      }

      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
