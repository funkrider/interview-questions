(ns interview-questions.05-Valid-Binary-Search-Tree-test
  (:require [clojure.test :refer :all]
            [interview-questions.05-Valid-Binary-Search-Tree :refer :all]))

(testing "tree structure"

  (is (= true (isBST {:value 5 :left nil :right nil}) ))


  (is (= true (isBST {:value 5 :left
                             {:value 2 :left nil :right nil} :right nil}) ))

  (is (= false (isBST {:value 5 :left
                             {:value 7 :left nil :right nil} :right nil}) ))



  (is (= true (isBST {:value 5 :left nil
                             :right {:value 7 :left nil :right nil} }) ))

  (is (= false (isBST {:value 5 :left nil
                               :right {:value 2 :left nil :right nil}}) ))



  (is (= true (isBST {:value 5
                      :left {:value 2 :left nil :right nil}
                      :right {:value 7 :left nil :right nil}}) ))

  (is (= false (isBST {:value 5
                       :left {:value 7 :left nil :right nil}
                       :right {:value 2 :left nil :right nil}}) ))


  )