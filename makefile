SLIDESTEX := noanim_traversal.tex traversal.tex

SOURCESTEX := $(shell ls *.src *.tex)
SLIDESPDF := $(addsuffix .pdf,$(basename $(SLIDESTEX)))
CLEANTARGETS := log aux out ind bbl blg lof lot toc idx acn acr alg glg glo gls fls fdb_latexmk auxlock md5 SATZE ZSM UB TOP listing upa ilg TOPIC DEFS vrb snm nav atfi

all: $(SLIDESPDF)

%.pdf: %.tex $(SOURCESTEX)
	sltxrc $<

clean:
	for fd in $(CLEANTARGETS); do rm -f *.$$fd; done
	rm -f *.pdf
