// Singleton Pattern : Ensures a class has only one instance and provides a global point of access to it.
// This is useful when exactly one object is needed to coordinate actions across the system.
// The Singleton pattern is often used for logging, driver objects, caching, thread pools, etc.
// The Singleton pattern can be implemented in various ways, such as using a private constructor, a static instance variable, and a public static method to access the instance.
// The Singleton pattern is a creational design pattern that restricts the instantiation of a class to one single instance.
// It is used when exactly one object is needed to coordinate actions across the system.
// The Singleton pattern is often used for logging, driver objects, caching, thread pools, etc.
// The Singleton pattern can be implemented in various ways, such as using a private constructor, a static instance variable, and a public static method to access the instance.
// The Singleton pattern is a creational design pattern that restricts the instantiation of a class to one single instance.
// It is used when exactly one object is needed to coordinate actions across the system.

// Understand the problem

// class JudgeAnalytics{
//     private int countRun;
//     private int countSubmit;

//     public void run(){
//         countRun++;
//     }
//     public void submit(){
//         countSubmit++;
//     }
//     public int getRunCount(){
//         return countRun;
//     }
//     public int getSubmitCount(){
//         return countSubmit;
//     }
// }

// Eager Loding -- Its is Thread Safe

// class JudgeAnalytics{
//     private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
//     private int countRun;
//     private int countSubmit;
//     private JudgeAnalytics(){

//     }

//     public static JudgeAnalytics getInstance(){
//         return judgeAnalytics;
//     }
    

//     public void run(){
//         countRun++;
//     }
//     public void submit(){
//         countSubmit++;
//     }
//     public int getRunCount(){
//         return countRun;
//     }
//     public int getSubmitCount(){
//         return countSubmit;
//     }
// }


// Lazy Loading (on demand object creation)

// class JudgeAnalytics{
//     private static JudgeAnalytics judgeAnalytics;
//     private int countRun;
//     private int countSubmit;
//     private JudgeAnalytics(){

//     }
//     // Not Thread safe
//     // public static JudgeAnalytics getInstance(){
//     //     if(judgeAnalytics == null) {
//     //         judgeAnalytics = new JudgeAnalytics();
//     //     }
//     //     return judgeAnalytics;
//     // }

//     // Synchornized Method to Thread Safety
//     public static synchronized JudgeAnalytics getInstance(){
//         if(judgeAnalytics == null) {
//             judgeAnalytics = new JudgeAnalytics();
//         }
//         return judgeAnalytics;
//     }

//     public void run(){
//         countRun++;
//     }
//     public void submit(){
//         countSubmit++;
//     }
//     public int getRunCount(){
//         return countRun;
//     }
//     public int getSubmitCount(){
//         return countSubmit;
//     }
// }

// Double Check Locking -- Thread Safe

// class JudgeAnalytics{
//     private static volatile JudgeAnalytics judgeAnalytics;
//     private int countRun;
//     private int countSubmit;
//     private JudgeAnalytics(){

//     }
    
//     public static JudgeAnalytics getInstance(){
//         if(judgeAnalytics == null) {
//             synchronized(JudgeAnalytics.class) {
//                 if(judgeAnalytics == null) {
//                     judgeAnalytics = new JudgeAnalytics();
//                 }
//             }
//         }
//         return judgeAnalytics;
//     }

//     public void run(){
//         countRun++;
//     }
//     public void submit(){
//         countSubmit++;
//     }
//     public int getRunCount(){
//         return countRun;
//     }
//     public int getSubmitCount(){
//         return countSubmit;
//     }
// }

// Bill - Push Singelton

class JudgeAnalytics{
    
    private int countRun;
    private int countSubmit;
    private JudgeAnalytics(){

    }
    private static class Holder{
        private static JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
    }
    public static JudgeAnalytics getInstance(){
        
        return Holder.judgeAnalytics;
    }

    public void run(){
        countRun++;
    }
    public void submit(){
        countSubmit++;
    }
    public int getRunCount(){
        return countRun;
    }
    public int getSubmitCount(){
        return countSubmit;
    }
}



// 
public class SingleTonePattern {
    public static void main(String[] args) {
        JudgeAnalytics judgeAnalytics = JudgeAnalytics.getInstance();
        judgeAnalytics.run();
        judgeAnalytics.submit();

        JudgeAnalytics judgeAnalytics2 =  JudgeAnalytics.getInstance();
        judgeAnalytics2.run();

        System.out.println(judgeAnalytics2.getRunCount());
    }
}
