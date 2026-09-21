SLIDESTEX := noanim_inplace-merge.tex inplace-merge.tex

SOURCESTEX := $(wildcard *.src *.tex)
SLIDESPDF := $(addsuffix .pdf,$(basename $(SLIDESTEX)))
CLEANTARGETS := log aux out ind bbl blg lof lot toc idx acn acr alg glg glo gls fls fdb_latexmk auxlock md5 SATZE ZSM UB TOP listing upa ilg TOPIC DEFS vrb snm nav atfi

LATEXMK := latexmk -pdf -interaction=nonstopmode

all: $(SLIDESPDF)

%.pdf: %.tex $(SOURCESTEX)
	$(LATEXMK) $<

clean:
	$(LATEXMK) -C
	for fd in $(CLEANTARGETS); do rm -f *.$$fd; done
	rm -f *.pdf

.PHONY: all clean
