(ns interview-questions.06-Anagram-test
  (:require [clojure.test :refer :all]
            [interview-questions.06-Anagram :refer :all]))


(testing "Anagrams"

  (is (= true (is-anagram? "abcd" "abcd")))
  (is (= false (is-anagram? "abcd" "abc")))
  (is (= true (is-anagram? "ab .c,d" "ab, '(c d")))
  (is (= true (is-anagram? "ABCD" "abcd")))

  )