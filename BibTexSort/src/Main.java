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
            System.out.println("}");
        }

    }
    public static class ByName implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.name.compareToIgnoreCase(a.name);}
    }
    public static class ByTitle implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.title.compareToIgnoreCase(a.title);}
    }
    public static class ByAuthor implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.author.compareToIgnoreCase(a.author);}
    }
    public static class ByOrganization implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.organization.compareToIgnoreCase(a.organization);}
    }
    public static class ByPublisher implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.publisher.compareToIgnoreCase(a.publisher);}
    }
    public static class ByBookTitle implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.booktitle.compareToIgnoreCase(a.booktitle);}
    }
    public static class ByJournal implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.journal.compareToIgnoreCase(a.journal);}
    }
    public static class ByType implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.type.compareToIgnoreCase(a.type);}
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
            for (int c = 0; c <= aux.length-1; c++)
                aux[c] = null;
            for (int k = lo; k <= hi; k++)
                aux[k] = a[k];
            int i = lo, j = mid+1;
            for (int k = lo; k <= hi; k++)
            {
                if (i > mid) a[k] = aux[j++];
                else if (j > hi) a[k] = aux[i++];
                else if (comparator.compare(aux[i], aux[j]) < 0) a[k] = aux[j++];
                else a[k] = aux[i++];
            }
        }
        public static void sort(bibTexObj[] a, Comparator<bibTexObj> comparator, boolean reverse){
            bibTexObj[] aux = new bibTexObj[a.length];
            if(reverse)
                reverse(a, aux, 0, a.length - 1,comparator);
            else
                sort(a, aux, 0, a.length - 1,comparator);
        }
        private static void sort(bibTexObj[] a, bibTexObj[] aux, int lo, int hi, Comparator<bibTexObj> comparator){
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid,comparator);
            sort(a, aux, mid+1, hi,comparator);
            merge(a, aux, lo, mid, hi,comparator);
        }
        private static void reverse(bibTexObj[] a, bibTexObj[] aux, int lo, int hi, Comparator<bibTexObj> comparator){
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            reverse(a, aux, lo, mid,comparator);
            reverse(a, aux, mid+1, hi,comparator);
            reverseMerge(a, aux, lo, mid, hi,comparator);
        }
        private static void reverseMerge(bibTexObj[] a, bibTexObj[] aux, int lo, int mid, int hi, Comparator<bibTexObj> comparator){
            for (int k = lo; k <= hi; k++)
                aux[k] = a[k];
            int i = lo, j = mid+1;
            for (int k = lo; k <= hi; k++)
            {
                if (i > mid) a[k] = aux[j++];
                else if (j > hi) a[k] = aux[i++];
                else if (comparator.compare(aux[i], aux[j]) >= 0) a[k] = aux[j++];
                else a[k] = aux[i++];
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

        boolean reverse = false;
        for(int j = args.length - 1; j > 0; j--){
            reverse = false;
            if(args[j].compareToIgnoreCase("-r") == 0){
                j--;
                reverse = true;
            }
            switch(args[j].toLowerCase()){
                case "name":
                    Merge.sort(bibTexObjs, new ByName(), reverse);
                    break;
                case "year":
                    Merge.sort(bibTexObjs, new ByYear(), reverse);
                    break;
                case "title":
                    Merge.sort(bibTexObjs, new ByTitle(), reverse);
                    break;
                case "author":
                    Merge.sort(bibTexObjs, new ByAuthor(), reverse);
                    break;
                case "organization":
                    Merge.sort(bibTexObjs, new ByOrganization(), reverse);
                    break;
                case "booktitle":
                    Merge.sort(bibTexObjs, new ByBookTitle(), reverse);
                    break;
                case "journal":
                    Merge.sort(bibTexObjs, new ByJournal(), reverse);
                    break;
                case "volume":
                    Merge.sort(bibTexObjs, new ByVolume(), reverse);
                    break;
                case "publisher":
                    Merge.sort(bibTexObjs, new ByPublisher(), reverse);
                    break;
                case "type":
                    Merge.sort(bibTexObjs, new ByType(), reverse);
                    break;
                case "number":
                    Merge.sort(bibTexObjs, new ByNumber(), reverse);
                    break;
                default:
                    break;
                //System.out.println(scan.next());
            }
        }
        //Collections.sort(bibTexObjs, new ByAuthor());
        //Merge.sort(bibTexObjs, new ByName());
        //Merge.sort(bibTexObjs, new ByYear());
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

