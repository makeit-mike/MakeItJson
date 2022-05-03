(ns ^:figwheel-hooks makeit-json.json-translate
  (:require
   [makeit-json.controller :as c]
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]))

;; -----------------------------------------------------------------------------
;; HTML EVENTS
;; -----------------------------------------------------------------------------

(defn submit-click []
  (->>
   (c/get-el-val "txtInput") 
   (c/parse-json)
   (c/set-el-val "txtOutput")))

(defn reset-click []
  ((c/set-el-val "txtInput" "")
   (c/set-el-val "txtOutput" "")))

;; -----------------------------------------------------------------------------
;; HTML COMPONENTS
;; -----------------------------------------------------------------------------

(defn intro-msg []
  [:div
   [:h1 "Convert JSON to Data Types"]
   [:h3 "Featuring Haskell, Clojure, and others"]
   [:p "(Work in progress)"]
   [:br]])

(defn json-input-table []
  [:div
   [:table {:style {:width "100%"}}
    [:tr
     [:td "JSON Input"]
     [:td [:textarea.InputField {:id "txtInput"}]]]]])

(defn json-output-table []
  [:div
   [:table {:style {:width "100%"}}
    [:tr
     [:td "Class Output"]
     [:td [:textarea.InputField {:id "txtOutput"}]]]]])

(defn submit-area []
  [:div.SubmitArea
   [:select {:id "ddlLanguage"}
    [:option "Select a language"]
    [:option "Haskell"]
    [:option "Clojure"]
    [:option "C#"]]
   [:div {:style {:width "20%"}}]
   [:button {:on-click #(submit-click)} "Process"]
   [:button {:on-click #(reset-click)} "Reset"]])

;; -----------------------------------------------------------------------------
;; MAIN ENTRY DIV
;; -----------------------------------------------------------------------------

(defn render []
  [:div.RenderMain
   [intro-msg]
   [json-input-table]
   [submit-area]
   [json-output-table]])

;; -----------------------------------------------------------------------------
;; EOF
;; -----------------------------------------------------------------------------
