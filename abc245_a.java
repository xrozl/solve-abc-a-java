import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        new Calc().done();
    }
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;
        private boolean hasNextByte() {
            if (ptr < buflen) {
                return true;
            }else{
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (buflen <= 0) {
                    return false;
                }
            }
            return true;
        }
        private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
        private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
        public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while(isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }
        public long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            boolean minus = false;
            int b = readByte();
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            if (b < '0' || '9' < b) {
                throw new NumberFormatException();
            }
            while(true){
                if ('0' <= b && b <= '9') {
                    n *= 10;
                    n += b - '0';
                }else if(b == -1 || !isPrintableChar(b)){
                    return minus ? -n : n;
                }else{
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }
        public int nextInt() {
            long nl = nextLong();
            if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
            return (int) nl;
        }
        public double nextDouble() { return Double.parseDouble(next());}
    }
    static class Calc{
        FastScanner s=new FastScanner();
        long st=System.currentTimeMillis();
        long nl(){return s.nextLong();}
        int ni(){return s.nextInt();}
        double nd(){return s.nextDouble();}
        String ns(){return s.next();}
        void a(Object o){System.out.print(o);}
        void as(Object o){System.out.print(o+" ");}
        void ab(Object o){System.out.println(o);}
        void ab(){System.out.println();}
        void ptl(Object o){System.out.println(o);}
        void aba(Object... o){String s="";for(Object j:o)s=s+j+" ";System.out.println(s.replaceFirst(".$",""));}
        long t(){return System.currentTimeMillis()-st;}
        int sum(int... i){return Arrays.stream(i).sum();}
        double sum(double... d){return Arrays.stream(d).sum();}
        long sum(long... l){return Arrays.stream(l).sum();}
        int[] ascending(int... i){Arrays.sort(i);return i;}
        Integer[] ascending(List<Integer> i){Integer[] k=i.toArray(new Integer[0]);Arrays.sort(k);return k;}
        int[] descending(int... i){i=ascending(i);for(int f=0,l=i.length-1;f<l;f++,l--){int t=i[f];i[f]=i[l];i[l]=t;}return i;}
        Integer[] descending(List<Integer> i){Integer[] k=ascending(i);for(int f=0,l=k.length-1;f<l;f++,l--){int t=k[f];k[f]=k[l];k[l]=t;}return k;}
        boolean match(int... i){for(int k:i)if(i[0]!=k)return false;return true;}
        long cc(String s,char a){long i=0;char t;for(int j=0;j<s.length();j++){if(s.charAt(j)==a)i++;}return i;}
        void tt(){a("Time "+t()+"ms");}
        Calc(){}
        void done() {
            int a, b, c, d;
            a = ni();
            b = ni();
            c = ni();
            d = ni();
            if (a < c) ab("Takahashi");
            else if (a > c) ab("Aoki");
            else if (b <= d) ab("Takahashi");
            else ab("Aoki");
        }
    }
}