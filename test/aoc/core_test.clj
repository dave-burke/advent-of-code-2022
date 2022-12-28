(ns aoc.core-test
  (:require [clojure.test :refer :all]
            [aoc.core :refer :all]))

(deftest a-test
  (testing "Day 01 Part 1 example"
    (is (= 24000 (-main "01" "1" "example"))))
  (testing "Day 01 Part 2 example"
    (is (= 45000 (-main "01" "2" "example"))))
  (testing "Day 02 Part 1 example"
    (is (= 15 (-main "02" "1" "example"))))
  (testing "Day 02 Part 2 example"
    (is (= 12 (-main "02" "2" "example"))))
  (testing "Day 03 Part 1 example"
    (is (= 157 (-main "03" "1" "example"))))
  (testing "Day 03 Part 2 example"
    (is (= 70 (-main "03" "2" "example"))))
  (testing "Day 04 Part 1 example"
    (is (= 2 (-main "04" "1" "example"))))
  (testing "Day 04 Part 2 example"
    (is (= 4 (-main "04" "2" "example"))))
  (testing "Day 05 Part 1 example"
    (is (= "CMZ" (-main "05" "1" "example"))))
  (testing "Day 05 Part 2 example"
    (is (= "MCD" (-main "05" "2" "example"))))
  (testing "Day 06 Part 1 example 1"
    (is (= 7 (-main "06" "1" "example-1"))))
  (testing "Day 06 Part 2 example 1"
    (is (= 19 (-main "06" "2" "example-1"))))
  (testing "Day 07 Part 1 example"
    (is (= "95437" (-main "07" "1" "example")))))

