package karsiwek.day01


val input: String = """
126918
61055
127240
80396
81162
51562
65881
103690
60737
130287
135856
116201
111257
56821
140446
79474
53915
117607
90340
119441
104310
54878
145597
63672
120426
117274
145815
98928
112061
61091
59853
92848
57280
111191
137234
51435
98024
118481
70074
52657
82087
90807
120340
92461
95208
91772
146344
54019
80841
89674
83631
103716
79867
140322
128222
82513
74542
123335
109266
91775
84558
143633
68537
125613
115249
106722
126196
123520
83653
78161
66515
67681
64915
120920
129749
128321
84940
147447
123313
130979
93585
130943
138492
134339
52050
148859
69934
132482
57521
114065
121381
136906
64219
119773
149996
120905
82315
144288
56069
80620
""".trimIndent()

fun getFuel(input: String): Int {
    return input
            .split("\n")
            .filter {!it.trim().equals("") }
            .map { getFuelForSingleMass(it.toInt()) }
            .sum()
}

fun getFuelForSingleMass(mass: Int): Int {
    return Math.max(0, (mass / 3) - 2);
}

fun main(args: Array<String>) {
    System.out.println(getFuelForSingleMass(12));
    System.out.println(getFuelForSingleMass(14));
    System.out.println(getFuelForSingleMass(1969));
    System.out.println(getFuelForSingleMass(100756));
    System.out.println(getFuel(input));
}
