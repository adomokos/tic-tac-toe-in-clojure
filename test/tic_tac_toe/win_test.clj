(ns tic-tac-toe.win-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.win :refer :all]))

(deftest finds-winner-test
  (testing "easily spots a winner for the first line"
    (let [board [[:X :X :X] [:O :O :_] [:_ :_ :_]]]
    (is (= {:X [[0 0] [0 1] [0 2]]} (has-winner? board))))))
