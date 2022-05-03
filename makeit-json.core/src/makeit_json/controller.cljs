(ns ^:figwheel-hooks makeit-json.controller
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]))

;; -----------------------------------------------------------------------------
;; Abstractions
;; -----------------------------------------------------------------------------

(defn get-el-val [el]
  (-> js/document
      (.getElementById el)
      (.-value)))

(defn set-el-val [el val]
  (-> js/document
      (.getElementById el)
      (.-value)
      (set! val)))

(defn clear-el-val [el]
  (-> js/document
      (.getElementById el)
      (.-value)
      (set! "")))

(defn parse-json [txt]
  (->
   (.parse js/JSON txt)
   (js->clj :keywordize-keys true)))

;; -----------------------------------------------------------------------------
;; TESTING
;; -----------------------------------------------------------------------------
(def json-str "{\"foo\": 1, \"bar\": 2, \"baz\": [1,2,3]}")

(defn clj->json
  [ds]
  (.stringify js/JSON (clj->js ds)))

(def a (.parse js/JSON json-str))
(js->clj a :keywordize-keys true)

(let [json (clj->json json-str)]
  json)

(parse-json json-str)

;; EXAMPLE INPUT
;; [
;;   {"type":"directory","name":".","contents":[
;;     {"type":"directory","name":"makeit_json","contents":[
;;       {"type":"file","name":"core.cljs"},
;;       {"type":"file","name":"css.cljs"},
;;       {"type":"file","name":"html.cljs"}
;;   ]}
;;   ]}
;; ,
;;   {"type":"report","directories":1,"files":3}
;; ]

;; CURRENTLY GIVES THIS OUTPUT
(def test-res
  [{:type "directory", :name ".",
    :contents [{:type "directory", :name "makeit_json",
                :contents [{:type "file", :name "core.cljs"}
                           {:type "file", :name "css.cljs"}
                           {:type "file", :name "html.cljs"}]}]}
   {:type "report", :directories 1, :files 3}])

;; idea
;; [] are arrays 
;; {} are data types
;; everything else is either a string, int, bool, or char?