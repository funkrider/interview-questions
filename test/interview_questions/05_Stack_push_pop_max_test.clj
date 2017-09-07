(ns interview-questions.05-Stack-push-pop-max-test
  (:require [clojure.test :refer :all]
            [interview-questions.05-Stack-push-pop-max :refer :all]))

(binding [a-stack (atom '())
          max-value (atom Integer/MIN_VALUE)
          max-index-stack (atom '())]

  (testing "stack push pop with max"

    ;"a-stack " ()
    ;"max-value " 100
    ;"max-index-stack " ()

    ;(set! a-stack '())
    ;(set! max-value Integer/MIN_VALUE)
    ;(set! max-index-stack '())

    (is (= @a-stack '()))
    (is (= @max-value Integer/MIN_VALUE))
    (is (= @max-index-stack '()))

    (pushx a-stack 100 max-value max-index-stack)

    (is (= @max-value 100))

    (pushx a-stack 110 max-value max-index-stack)

    (is (= @max-value 110))

    (pushx a-stack 10 max-value max-index-stack)

    (is (= @max-value 110))

    (popx a-stack max-value max-index-stack)

    (is (= @max-value 110))

    )
)