# wordcount.py - Count the number of occurences of each unique word in a text file.
import sys

def wordCount(wc, str):
	words = str.split()
	for w in words:
		wc[w] = wc.get(w,0) + 1
	return wc

if (len(sys.argv) != 2):
	print "usage: wordcount <textfile>"
	sys.exit(1)
wc = {}
with open(sys.argv[1]) as f:
	for line in f:
		wordCount(wc, line)
for (w,c) in wc.items():
	print c, w
