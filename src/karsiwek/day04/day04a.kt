package karsiwek.day04


val start: Int = 246540;
val stop: Int = 787419;

val startMe: Int = 246540;
val stopMe: Int = 787419;

fun isValidPassword(password: Int) :Int {
    var stringPass = password.toString();
    for(i in 0..stringPass.length-2){
        if(stringPass.get(i).toByte() > stringPass.get(i+1).toByte()){
            return 0;
        }
    }

    if(stringPass.toSet().size == stringPass.length){
        return 0
    }

    return 1;
}

fun calculatePasswords(start:Int, stop:Int) :Int {
        if(start>=stop){
            return isValidPassword(stop);
        }
       return calculatePasswords(start, (start+stop)/2) + calculatePasswords(1+(start+stop)/2, stop);
}

fun main(args: Array<String>) {
    System.out.println(isValidPassword(111111));
    System.out.println(isValidPassword(223450));
    System.out.println(isValidPassword(123789));

    System.out.println(calculatePasswords(246540, 787419));

}

