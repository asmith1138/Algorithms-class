**********BibTexSort**********
Usage: Build and navigate to output directory
java Main <filepath> <recursively: <sort key> <optional: -r>>

example: java Main "E:\Andrew\My Documents\Masters\CMPSC 463\BibTexSort\bug_triage.bib" Year
example: java Main "E:\Andrew\My Documents\Masters\CMPSC 463\BibTexSort\bug_triage.bib" Year -r
example: java Main "E:\Andrew\My Documents\Masters\CMPSC 463\BibTexSort\bug_triage.bib" Year Author
example: java Main "E:\Andrew\My Documents\Masters\CMPSC 463\BibTexSort\bug_triage.bib" Year Author -r
example: java Main "E:\Andrew\My Documents\Masters\CMPSC 463\BibTexSort\bug_triage.bib" Year -r Author -r

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