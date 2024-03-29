//import org.jbibtex;

import java.io.*;
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
        public String volume = "";
        public String number = "";
        public String journal = "";
        public String type = "";
        public String numpages = "";
        public String url = "";
        public String howpublished = "";
        public String note = "";
        public String isbn = "";
        public String address = "";
        public String doi = "";
        public String location = "";
        public String abstractText = "";
        public String keywords = "";
        public String series = "";
        public String fullText = "";

        public bibTexObj(){}
        public bibTexObj(String bibtexString){
            if(!bibtexString.isEmpty())
                this.parseInto(bibtexString);
        }
        public void parseInto(String bibtex){
            this.fullText = bibtex.trim();
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
                //I would much rather use (?<=title(\s+)?=(\s+)?{)((?!},).)*(?=})
                //but Java does not support repeating characters in lookarounds
                //title
                pattern = Pattern.compile("(?<=title(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.title = matcher.group(0);
                }
                //author
                pattern = Pattern.compile("(?<=author(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.author = matcher.group(0);
                }
                //journal
                pattern = Pattern.compile("(?<=journal(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.journal = matcher.group(0);
                }
                //volume
                pattern = Pattern.compile("(?<=volume(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.volume = matcher.group(0);
                }
                //number
                pattern = Pattern.compile("(?<=number(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.number = matcher.group(0);
                }
                //pages
                pattern = Pattern.compile("(?<=pages(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.pages = matcher.group(0);
                }
                //year
                pattern = Pattern.compile("(?<=year(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.year = Integer.parseInt(matcher.group(0));
                }
                //publisher
                pattern = Pattern.compile("(?<=publisher(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.publisher = matcher.group(0);
                }
                //booktitle
                pattern = Pattern.compile("(?<=booktitle(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.booktitle = matcher.group(0);
                }
                //organization
                pattern = Pattern.compile("(?<=organization(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.organization = matcher.group(0);
                }

                //numpages
                pattern = Pattern.compile("(?<=numpages(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.numpages = matcher.group(0);
                }

                //url
                pattern = Pattern.compile("(?<=url(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.url = matcher.group(0);
                }

                //howpublished
                pattern = Pattern.compile("(?<=howpublished(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=}})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.howpublished = matcher.group(0);
                }

                //note
                pattern = Pattern.compile("(?<=note(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.note = matcher.group(0);
                }

                //isbn
                pattern = Pattern.compile("(?<=isbn(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.isbn = matcher.group(0);
                }

                //address
                pattern = Pattern.compile("(?<=address(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.address = matcher.group(0);
                }

                //location
                pattern = Pattern.compile("(?<=location(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.location = matcher.group(0);
                }

                //doi
                pattern = Pattern.compile("(?<=doi(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.doi = matcher.group(0);
                }

                //abstractText
                pattern = Pattern.compile("(?<=abstract(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.abstractText = matcher.group(0);
                }

                //keywords
                pattern = Pattern.compile("(?<=keywords(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.keywords = matcher.group(0);
                }

                //series
                pattern = Pattern.compile("(?<=series(\\s)?=(\\s)?(\\s)?(\\s)?(\\s)?\\{)((?!},).)*(?=})");
                matcher = pattern.matcher(bibtex);
                if(matcher.find()){
                    this.series = matcher.group(0);
                }
                //System.out.println(bibtex);
            }
        }

        public void print(){
            System.out.println("@" + type + "{" + name + ",");
            if(!title.isEmpty())
                System.out.println("\ttitle={" + title + "},");
            if(!author.isEmpty())
                System.out.println("\tauthor={" + author + "},");
            if(!pages.isEmpty())
                System.out.println("\tpages={" + pages + "},");
            if(year != 0)
                System.out.println("\tyear={" + year + "},");
            if(!organization.isEmpty())
                System.out.println("\torganization={" + organization + "},");
            if(!publisher.isEmpty())
                System.out.println("\tpublisher={" + publisher + "},");
            if(!booktitle.isEmpty())
                System.out.println("\tbooktitle={" + booktitle + "},");
            if(!volume.isEmpty())
                System.out.println("\tvolume={" + volume + "},");
            if(!number.isEmpty())
                System.out.println("\tnumber={" + number + "},");
            if(!journal.isEmpty())
                System.out.println("\tjournal={" + journal + "},");
            if(!url.isEmpty())
                System.out.println("\turl={" + url + "},");
            if(!numpages.isEmpty())
                System.out.println("\tnumpages={" + numpages + "},");
            if(!howpublished.isEmpty())
                System.out.println("\thowpublished={" + howpublished + "},");
            if(!note.isEmpty())
                System.out.println("\tnote={" + note + "},");
            if(!isbn.isEmpty())
                System.out.println("\tisbn={" + isbn + "},");
            if(!address.isEmpty())
                System.out.println("\taddress={" + address + "},");
            if(!location.isEmpty())
                System.out.println("\tlocation={" + location + "},");
            if(!doi.isEmpty())
                System.out.println("\tdoi={" + doi + "},");
            if(!abstractText.isEmpty())
                System.out.println("\tabstract={" + abstractText + "},");
            if(!keywords.isEmpty())
                System.out.println("\tkeywords={" + keywords + "},");
            if(!series.isEmpty())
                System.out.println("\tseries={" + series + "},");
            System.out.println("}\n");
        }

        public String ToString() {
            //FileWriter writer = new FileWriter(filepath);
            String tostring = "@" + type + "{" + name + ",\n";
            //writer.append("@" + type + "{" + name + ",\n");
            if(!title.isEmpty())
                tostring += "\ttitle={" + title + "},\n";
            if(!author.isEmpty())
                tostring += "\tauthor={" + author + "},\n";
            if(!pages.isEmpty())
                tostring += "\tpages={" + pages + "},\n";
            if(year != 0)
                tostring += "\tyear={" + year + "},\n";
            if(!organization.isEmpty())
                tostring += "\torganization={" + organization + "},\n";
            if(!publisher.isEmpty())
                tostring += "\tpublisher={" + publisher + "},\n";
            if(!booktitle.isEmpty())
                tostring += "\tbooktitle={" + booktitle + "},\n";
            if(!volume.isEmpty())
                tostring += "\tvolume={" + volume + "},\n";
            if(!number.isEmpty())
                tostring += "\tnumber={" + number + "},\n";
            if(!journal.isEmpty())
                tostring += "\tjournal={" + journal + "},\n";
            if(!series.isEmpty())
                tostring += "\tseries={" + series + "},\n";
            if(!keywords.isEmpty())
                tostring += "\tkeywords={" + keywords + "},\n";
            if(!abstractText.isEmpty())
                tostring += "\tabstract={" + abstractText + "},\n";
            if(!location.isEmpty())
                tostring += "\tlocation={" + location + "},\n";
            if(!numpages.isEmpty())
                tostring += "\tnumpages={" + numpages + "},\n";
            if(!url.isEmpty())
                tostring += "\turl={" + url + "},\n";
            if(!howpublished.isEmpty())
                tostring += "\thowpublished={" + howpublished + "},\n";
            if(!note.isEmpty())
                tostring += "\tnote={" + note + "},\n";
            if(!isbn.isEmpty())
                tostring += "\tisbn={" + isbn + "},\n";
            if(!address.isEmpty())
                tostring += "\taddress={" + address + "},\n";
            if(!doi.isEmpty())
                tostring += "\tdoi={" + doi + "},\n";
            tostring += "}\n\n";
            return tostring;
        }

        public void simplifiedPrint(){
            System.out.println("@" + fullText);
            System.out.println("},\n\n");
        }

        public String simplifiedToString() {
            return "@" + fullText + ",\n\n";
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
    public static class ByURL implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.url.compareToIgnoreCase(a.url);}
    }
    public static class ByHowPublished implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.howpublished.compareToIgnoreCase(a.howpublished);}
    }
    public static class ByNote implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.note.compareToIgnoreCase(a.note);}
    }
    public static class ByISBN implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.isbn.compareToIgnoreCase(a.isbn);}
    }
    public static class ByAddress implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.address.compareToIgnoreCase(a.address);}
    }
    public static class ByDOI implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.doi.compareToIgnoreCase(a.doi);}
    }
    public static class ByLocation implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.location.compareToIgnoreCase(a.location);}
    }
    public static class ByAbstract implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.abstractText.compareToIgnoreCase(a.abstractText);}
    }
    public static class BySeries implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.series.compareToIgnoreCase(a.series);}
    }
    public static class ByVolume implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.volume.compareToIgnoreCase(a.volume);}
    }
    public static class ByNumber implements Comparator<bibTexObj>{
        public int compare(bibTexObj a, bibTexObj b) {return b.number.compareToIgnoreCase(a.number);}
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
    public void run(String[] args) {
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

        boolean reverse;
        for(int j = args.length - 1; j > 1; j--){
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
                case "url":
                    Merge.sort(bibTexObjs, new ByURL(), reverse);
                    break;
                case "howpublished":
                    Merge.sort(bibTexObjs, new ByHowPublished(), reverse);
                    break;
                case "note":
                    Merge.sort(bibTexObjs, new ByNote(), reverse);
                    break;
                case "isbn":
                    Merge.sort(bibTexObjs, new ByISBN(), reverse);
                    break;
                case "address":
                    Merge.sort(bibTexObjs, new ByAddress(), reverse);
                    break;
                case "doi":
                    Merge.sort(bibTexObjs, new ByDOI(), reverse);
                    break;
                case "location":
                    Merge.sort(bibTexObjs, new ByLocation(), reverse);
                    break;
                case "abstract":
                    Merge.sort(bibTexObjs, new ByAbstract(), reverse);
                    break;
                case "series":
                    Merge.sort(bibTexObjs, new BySeries(), reverse);
                    break;
                default:
                    break;
                //System.out.println(scan.next());
            }
        }
        if(args[1].equalsIgnoreCase("out"))
            for(bibTexObj citation : bibTexObjs)
                citation.simplifiedPrint();
        else{
            File f = new File(args[1]);
            String print = "";
            try {
                f.createNewFile();
                FileWriter writer = new FileWriter(args[1]);
                for(bibTexObj citation : bibTexObjs)
                    print += citation.simplifiedToString();
                writer.write(print);
                writer.close();
            }
            catch (IOException e){
                System.out.println("Output file cannot be created");
            }
        }

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

