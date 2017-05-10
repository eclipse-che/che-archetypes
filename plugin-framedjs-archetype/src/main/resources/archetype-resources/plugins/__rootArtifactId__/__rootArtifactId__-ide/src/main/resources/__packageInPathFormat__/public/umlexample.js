var graph = new joint.dia.Graph();

var paper = new joint.dia.Paper({
    el: $('#paper'),
    width: 800,
    height: 450,
    gridSize: 10,
    drawGrid: false,
    model: graph
});


var uml = joint.shapes.uml;

var states = {

    s0: new uml.StartState({
        position: { x:185  , y: 20 },
        size: { width: 30, height: 30 },
        attrs: {
            'circle': {
                fill: '#4b4a67',
                stroke: 'none'
            }
        }
    }),

    s1: new uml.State({
        position: { x:100  , y: 80 },
        size: { width: 200, height: 80 },
        name: "state 1",
        events: ["entry / init()"],
        attrs: {
            '.uml-state-body': {
                fill: 'rgba(48, 208, 198, 0.1)',
                stroke: 'rgba(48, 208, 198, 0.5)',
                'stroke-width': 1.5
            },
            '.uml-state-separator': {
                stroke: 'rgba(48, 208, 198, 0.4)'
            }
        }
    }),

    s2: new uml.State({
        position: { x:120  , y: 210 },
        size: { width: 160, height: 60 },
        name: "state 2",
        events: ["entry / process()"],
        attrs: {
            '.uml-state-body': {
                fill: 'rgba(48, 208, 198, 0.1)',
                stroke: 'rgba(48, 208, 198, 0.5)',
                'stroke-width': 1.5
            },
            '.uml-state-separator': {
                stroke: 'rgba(48, 208, 198, 0.4)'
            }
        }
    }),

    s3: new uml.State({
        position: { x:120  , y: 320 },
        size: { width: 160, height: 50 },
        name: "state 3",
        events: ["exit / destroy()"],
        attrs: {
            '.uml-state-body': {
                fill: 'rgba(48, 208, 198, 0.1)',
                stroke: 'rgba(48, 208, 198, 0.5)',
                'stroke-width': 1.5
            },
            '.uml-state-separator': {
                stroke: 'rgba(48, 208, 198, 0.4)'
            }
        }
    }),

    se: new uml.EndState({
        position: { x:185, y: 400 },
        size: { width: 30, height: 30 },
        attrs: {
            '.outer': {
                stroke: "#4b4a67",
                'stroke-width': 2
            },
            '.inner': {
                fill: '#4b4a67'
            }
        }
    })

};
_.each(states, function(c) { graph.addCell(c); });

var linkAttrs =  {
    'fill': 'none',
    'stroke-linejoin': 'round',
    'stroke-width': '2',
    'stroke': '#4b4a67'
};

var transitons = [
    new uml.Transition({
        source: { id: states.s0.id },
        target: { id: states.s1.id },
        attrs: {'.connection': linkAttrs }
    }),
    new uml.Transition({
        source: { id: states.s1.id },
        target: { id: states.s2.id },
        attrs: {'.connection': linkAttrs }
    }),
    new uml.Transition({
        source: { id: states.s2.id },
        target: { id: states.s3.id },
        attrs: {'.connection': linkAttrs }
    }),
    new uml.Transition({
        source: { id: states.s3.id },
        target: { id: states.se.id },
        attrs: {'.connection': linkAttrs }
    })
];

graph.addCells(transitons);

