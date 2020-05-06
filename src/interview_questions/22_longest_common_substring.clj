(ns interview-questions.22-longest-common-substring)

;;; Find the longest common substring between two strings.
;;; For example: "ABAB", "BABA" -> "ABA"
;;; 1) Brute Force - for every permutation compare
;;; 2) Create a Trie - then compare
;;; 3) Cache using an NxM matrix
;;; The matrix trick seems to be the favoured one because it is
;;; not obvious and gives a NxM runtime.



(defn longest-substring
  [a b]
  (let [a-len (count a)
        b-len (count b)
        cache (make-array Long/TYPE a-len b-len)
        longest (atom "")
        do-debug false]
    (doseq [bi (range b-len)
            ai (range a-len)]
      (let [ax (get a ai)
            bx (get b bi)
            c  (cond
                 (not= ax bx) 0
                 (or (zero? ai) (zero? bi)) 1
                 :else (inc (aget cache (dec ai) (dec bi))))]
        (aset cache ai bi c)
        (when (> c (count @longest))
          (reset! longest (subs a (- (inc ai) c) (inc ai))))
        (when do-debug
          (clojure.pprint/pprint cache)
          (prn ai bi ax bx c @longest))))
    @longest))

(longest-substring "ABABANANA" "BABANANABOAT")
