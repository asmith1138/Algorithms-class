**********BibTexSort**********
Usage: Build and navigate to output directory
java Main <filepath> <outputFilePath> <recursively: <sort key> <optional: -r>>

example: java Main "E:\Andrew\My Documents\Masters\CMPSC 463\BibTexSort\bug_triage.bib" out Year
example: java Main "E:\Andrew\My Documents\Masters\CMPSC 463\BibTexSort\bug_triage.bib" out Year -r
example: java Main "E:\Andrew\My Documents\Masters\CMPSC 463\BibTexSort\bug_triage.bib" out Year Author
example: java Main "E:\Andrew\My Documents\Masters\CMPSC 463\BibTexSort\bug_triage.bib" "E:\Andrew\My Documents\Masters\CMPSC 463\BibTexSort\bug_triage.out" Year Author -r
example: java Main "E:\Andrew\My Documents\Masters\CMPSC 463\BibTexSort\bug_triage.bib" out Year -r Author -r

Using out as the outputFilePath will print to std out instead of an output file

You can input as many sort keys as you want and any sort key you want to sort in reverse must have a -r following it

Sort Key is case insensitive and valid values are below:

Name
Title
Author
Organization
Publisher
BookTitle
Journal
Type
Volume
Number
Year

Program currently prints result to stdout