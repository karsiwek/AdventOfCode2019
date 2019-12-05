package karsiwek.day04b

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

    var chain = 1;
    var maxChain = 0;
    for(i in 0..stringPass.length-2){
        if(stringPass.get(i).toByte() == stringPass.get(i+1).toByte()){
            chain++;
            maxChain = Math.max(maxChain, chain);
        } else {
            if(chain==2){
                return 1;
            }
            maxChain = Math.max(maxChain, chain);
            chain=1;
        }
    }

    if(chain==2){
        return 1;
    }

    if(maxChain>2){
        return 0;
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
    System.out.println(isValidPassword(111234));


    System.out.println(isValidPassword(112233));
    System.out.println(isValidPassword(123444));
    System.out.println(isValidPassword(111122));
    System.out.println(isValidPassword(122444));

    System.out.println(isValidPassword(112345));
    System.out.println(isValidPassword(122345));
    System.out.println(isValidPassword(123345));
    System.out.println(isValidPassword(123445));
    System.out.println(isValidPassword(123455));
    System.out.println(isValidPassword(122255));

    System.out.println(calculatePasswords(246540, 787419));
}

//odp: 881  -nie
