(ns ^:figwheel-hooks makeit-json.html
  (:require
   [makeit-json.json-translate :as json-translate]))

;; -----------------------------------------------------------------------------
;; MAIN ENTRY DIV
;; -----------------------------------------------------------------------------

;; TODO Add Switch here to decide which page to render
(defn render-main []
  (json-translate/render))