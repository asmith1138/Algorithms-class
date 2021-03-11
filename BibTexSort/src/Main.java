//import org.jbibtex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    protected class bibTexObj{
        public String title = "";
        public String author = "";
        public String pages = "";
        public int year = 2020;
        public String organization = "";
        public String name = "";
        public String publisher = "";
        public String booktitle = "";
        public int volume = 0;
        public int number = 0;
        public String journal = "";
        public String type = "";

        public bibTexObj(){}
        public bibTexObj(String title, String name, String author, int year){
            this.title=title;
            this.name=name;
            this.author=author;
            this.year=year;
        }
        public bibTexObj(String bibtexString){
            if(!bibtexString.isEmpty())
                this.parseInto(bibtexString);
        }
        public void parseInto(String bibtex){
            if(!bibtex.isEmpty()){
                //type
                Pattern pattern = Pattern.compile("\\w+(?=\\{)");
                Matcher matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.type = matcher.group(0);
                }
                //name
                pattern = Pattern.compile("(?<=(\\w)\\{)\\w+");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.name = matcher.group(0);
                }
                //title
                pattern = Pattern.compile("(?<=title=\\{)((?!\\}).)*(?=\\})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.title = matcher.group(0);
                }
                //author
                pattern = Pattern.compile("(?<=author=\\{)((?!\\}).)*(?=\\})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.author = matcher.group(0);
                }
                //journal
                pattern = Pattern.compile("(?<=journal=\\{)((?!\\}).)*(?=\\})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.journal = matcher.group(0);
                }
                //volume
                pattern = Pattern.compile("(?<=volume=\\{)((?!\\}).)*(?=\\})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.volume = Integer.parseInt(matcher.group(0));
                }
                //number
                pattern = Pattern.compile("(?<=number=\\{)((?!\\}).)*(?=\\})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.number = Integer.parseInt(matcher.group(0));
                }
                //pages
                pattern = Pattern.compile("(?<=pages=\\{)((?!\\}).)*(?=\\})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.pages = matcher.group(0);
                }
                //year
                pattern = Pattern.compile("(?<=year=\\{)((?!\\}).)*(?=\\})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.year = Integer.parseInt(matcher.group(0));
                }
                //publisher
                pattern = Pattern.compile("(?<=publisher=\\{)((?!\\}).)*(?=\\})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.publisher = matcher.group(0);
                }
                //booktitle
                pattern = Pattern.compile("(?<=booktitle=\\{)((?!\\}).)*(?=\\})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.booktitle = matcher.group(0);
                }
                //organization
                pattern = Pattern.compile("(?<=organization=\\{)((?!\\}).)*(?=\\})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.organization = matcher.group(0);
                }
                //System.out.println(bibtex);
            }
        }

        public void print(){
            System.out.println("@" + type + "{" + name + ",");
            if(!title.isEmpty())
                System.out.println("title={" + title + "},");
            if(!author.isEmpty())
                System.out.println("author={" + author + "},");
            if(!pages.isEmpty())
                System.out.println("pages={" + pages + "},");
            if(year != 0)
                System.out.println("year={" + year + "},");
            if(!organization.isEmpty())
                System.out.println("organization={" + organization + "},");
            if(!publisher.isEmpty())
                System.out.println("publisher={" + publisher + "},");
            if(!booktitle.isEmpty())
                System.out.println("booktitle={" + booktitle + "},");
            if(volume != 0)
                System.out.println("volume={" + volume + "},");
            if(number != 0)
                System.out.println("number={" + number + "},");
            if(!journal.isEmpty())
                System.out.println("journal={" + journal + "},");
        }

    }
    public static class ByName implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return a.name.compareTo(b.name);}
    }
    public static class ByTitle implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return a.title.compareTo(b.title);}
    }
    public static class ByAuthor implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return a.author.compareTo(b.author);}
    }
    public static class ByOrganization implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return a.organization.compareTo(b.organization);}
    }
    public static class ByPublisher implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return a.publisher.compareTo(b.publisher);}
    }
    public static class ByBookTitle implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return a.booktitle.compareTo(b.booktitle);}
    }
    public static class ByJournal implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return a.journal.compareTo(b.journal);}
    }
    public static class ByType implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return a.type.compareTo(b.type);}
    }

    public static class ByVolume implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return a.volume - b.volume;}
    }
    public static class ByNumber implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return a.number - b.number;}
    }
    public static class ByYear implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return a.year - b.year;}
    }

    public static class Merge
    {
        private static void merge(bibTexObj[] a, bibTexObj[] aux, int lo, int mid, int hi, Comparator<bibTexObj> comparator){
            int i = lo, j = mid+1;
            for (int k = lo; k <= hi; k++)
            {
                if (i > mid) aux[k] = a[j++];
                else if (j > hi) aux[k] = a[i++];
                else if (comparator.compare(a[i], a[j]) < 0) aux[k] = a[j++];
                else aux[k] = a[i++];
            }
        }
        public static void sort(bibTexObj[] a, Comparator<bibTexObj> comparator){
            bibTexObj[] aux = new bibTexObj[a.length];
            sort(a, aux, 0, a.length - 1,comparator);
        }
        private static void sort(bibTexObj[] a, bibTexObj[] aux, int lo, int hi, Comparator<bibTexObj> comparator){
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid,comparator);
            sort(a, aux, mid+1, hi,comparator);
            merge(a, aux, lo, mid, hi,comparator);
        }
        public static void reverse(bibTexObj[] a, Comparator<bibTexObj> comparator){
            bibTexObj[] aux = new bibTexObj[a.length];
            reverse(a, aux, 0, a.length - 1,comparator);
        }
        private static void reverse(bibTexObj[] a, bibTexObj[] aux, int lo, int hi, Comparator<bibTexObj> comparator){
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            reverse(a, aux, lo, mid,comparator);
            reverse(a, aux, mid+1, hi,comparator);
            reverseMerge(a, aux, lo, mid, hi,comparator);
        }
        private static void reverseMerge(bibTexObj[] a, bibTexObj[] aux, int lo, int mid, int hi, Comparator<bibTexObj> comparator){
            int i = lo, j = mid+1;
            for (int k = lo; k <= hi; k++)
            {
                if (i > mid) aux[k] = a[j++];
                else if (j > hi) aux[k] = a[i++];
                else if (comparator.compare(a[j], a[i]) < 0) aux[k] = a[j++];
                else aux[k] = a[i++];
            }
        }
    }

    public static void main(String[] args) {
        Main program = new Main();
        program.run(args);
    }
    public void run(String[] args){

        Scanner scan = new Scanner(System.in);

        String latexString = String.join("\n",readFile(args[0]));

        String[] split1 = latexString.split("@");
        bibTexObj[] bibTexObjs = new bibTexObj[split1.length - 1];
        int i = 0;
        for (String bibtex: split1) {
            if(!bibtex.isEmpty()){
                bibTexObjs[i] = new bibTexObj(bibtex);
                //bibTexObjs[i].print();
                i++;
            }
        }

        //Collections.sort(bibTexObjs, new ByAuthor());
        Merge.sort(bibTexObjs, new ByName());
        Merge.sort(bibTexObjs, new ByYear());
        for(bibTexObj citation : bibTexObjs)
            citation.print();
    }

    private static List<String> readFile(String filename)
    {
        List<String> records = new ArrayList<String>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null)
            {
                records.add(line);
            }
            reader.close();
            return records;
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }
}

