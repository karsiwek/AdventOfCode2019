package karsiwek.day01

fun getFuelForSingleMassAndFuel(mass: Int): Int {
    if(mass == 0) return 0;
    return getFuelForSingleMass(mass) + getFuelForSingleMassAndFuel(getFuelForSingleMass(mass))
}

fun getFuelForMassAndFuel(input: String): Int {
    return input
            .split("\n")
            .filter { !it.trim().equals("") }
            .map { getFuelForSingleMassAndFuel(it.toInt()) }
            .sum()
}

fun main(args: Array<String>) {
    System.out.println(getFuelForSingleMassAndFuel(12));
    System.out.println(getFuelForSingleMassAndFuel(14));
    System.out.println(getFuelForSingleMassAndFuel(1969));
    System.out.println(getFuelForSingleMassAndFuel(100756));
    System.out.println(getFuelForMassAndFuel(input));
}

