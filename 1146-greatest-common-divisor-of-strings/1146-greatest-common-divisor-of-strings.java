class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // 두개의 스트링중 제일 길이가 긴 x로 두개의 스트링에 포함시킬 수 있는지
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }        
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    public int gcd(int a, int b) { // 최대공약수
        while (b!=0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}