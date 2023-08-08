# 2021java-HomestuckUtilities
A variety of single-serving jars full of handy procedural bits and bobs.

Each subfolder is for a different utility, and should contain some sourcecode and a .jar that you should be able to run.

Changelog:

2023-08-08 :: -01:45- (v0.26) -- Added gender/reproductive gene plus description function.  Moved bloodcode, hue, caste, to Troll.body for easier access.  Added a lot of descriptive functions relating to caste, standardizing its layout and making it useful for identification in hybrids.  Began adding carapacian demographics.  Updated stats section, many grubs will be more powerful by a point or two, and some fae have aspect affiliations.  Standardized fae blood colors.  Added fae/carapacian/human bloodcodes.  Top of Gene.java has a list of supported species codes.  Changed a variety of subfunctions in Blood, Gene, and Desc, and updated Dancestry main and Troll to match.  Considering adding bulk redesc tool.  Began adding pigment desc function (unfinished).  Preparing to add power/syndrome descriptive functions, and fae names.  Procrastinated on updating for so long because I was quibbling over the gender stuff.  Probably going to continue to change it significantly.

2022-12-20 :: -18:12- (v0.25) -- More descriptions.  Started taking the eye datatype apart and shoving it in with the rest of the body subgenes, bits so far have been incorporated into feral and pupate.  Updating old trolls to new formats is easier with that redescribe function.

2022-12-13 :: -13:02- (V0.24) -- More fae/human compatibility.  Can now generate a random human or fae, and cross them with everyone else.  The description functions work better.  You can edit a saved troll file, and run it through the program again, to get new descriptions based off of what you changed.  The zipped binary includes some compatible trolls and fae.

2022-11-28 :: -15:35- (V0.23) -- officially using this version number now.  Added descriptive function for pupation gene, and a few misc things.

2022-11-26 :: -18:13- (V0.22) -- I don't remember what I've changed at all and I think my version numbering got confused - pretend 1.2 says 0.22.  Pigment Gene and Syndrome gene are done though, and there's a bit of new things in the strife, stats, and interests files.  Working on Description zone.  Adding more compatibility so humans and fae and various other species can be hybridized / saved in this file format.

2022-11-18 :: -06:33- (no jar) changed "limbgene" to "feralgene", added "pigmentgene" and "syndromegene" (currently vacuous), added feral teeth (normal, fang, barracuda, shark, rodent, tongue barbs, beak), added blank gene template to husk.body.  Save compatibility has been broken.

2022-11-16 :: -06:45- V0.2.1 (no jar) Added to-do lists to troll.husk.body, moved grubscars to pupation gene, moved skin coverings to feral gene and adjusted phrasings, added when stance goes from quad -> biped to pupation gene

2022-11-11 :: -11:45- V0.2 uploaded.  Updated Troll.husk.gene to get Permute working, updated troll.husk.body to correct a typo in the documentation at the top for fingene, updated troll.fluff.desc to actually provide descriptions and have those descriptions work.  Numerous small errors corrected.  Added a desc entry to the main Troll class so it gets saved along with everything else.  Desc now provides working descriptions of troll.body.build, troll.body.respiratorygene, and troll.body.fingene.  I'm looking at pupations, skin, and feral traits next.

2022-11-10 :: -05:39-  Updated elements, tags, some of the documentation in the horn section.  I might have unsaved progress but it's on a machine that's currently inaccessible, I'll incorporate those again when I can.  I'm not sure where exactly "titles" are, might redo that one.  I know it exists somewhere..

2021-06-23 :: -00:24-  Added titles, and Amici and Chibi's suggestions for word additions.  

2021-06-22 :: -13:20-  Added folder for Names-Tags-Titles.  Press a button, it generates a few names with trolltags.  Titles to be added.
