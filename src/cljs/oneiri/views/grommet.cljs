(ns oneiri.views.grommet
  (:require [reagent.core :as r]
            [cljsjs.react]
            [cljsjs.react.dom]
            [cljsjs.grommet]))


(def app   (r/adapt-react-class (.-App   js/Grommet)))
(def box   (r/adapt-react-class (.-Box   js/Grommet)))
(def split (r/adapt-react-class (.-Split js/Grommet)))
(def table (r/adapt-react-class (.-Table js/Grommet)))

(def table-row (r/adapt-react-class (.-TableRow js/Grommet)))
(def table-header (r/adapt-react-class (.-TableHeader js/Grommet)))

(def sidebar (r/adapt-react-class (.-Sidebar js/Grommet)))
(def header  (r/adapt-react-class (.-Header  js/Grommet)))
(def anchor  (r/adapt-react-class (.-Anchor  js/Grommet)))
(def footer  (r/adapt-react-class (.-Footer  js/Grommet)))
(def title   (r/adapt-react-class (.-Title   js/Grommet)))
(def menu    (r/adapt-react-class (.-Menu    js/Grommet)))
(def button  (r/adapt-react-class (.-Button  js/Grommet)))
(def layer   (r/adapt-react-class (.-Layer  js/Grommet)))

(def tiles   (r/adapt-react-class (.-Tiles  js/Grommet)))
(def tile    (r/adapt-react-class (.-Tile   js/Grommet)))

(def card   (r/adapt-react-class (.-Card  js/Grommet)))

(def glist   (r/adapt-react-class (.-List  js/Grommet)))
(def list-item   (r/adapt-react-class (.-ListItem  js/Grommet)))

(def heading   (r/adapt-react-class (.-Heading  js/Grommet)))
(def columns   (r/adapt-react-class (.-Columns  js/Grommet)))

(defn icon
  ([icon-name ]
   (icon icon-name {}))
  ([icon-name attrs]
   (let [ico  (aget js/Grommet.Icons.Base icon-name)]
     (r/as-element [:> ico attrs]))))
