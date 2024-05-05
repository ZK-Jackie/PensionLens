//展示有关政策知识图谱的JSON文件，包括政策知识图谱的节点和边，简单试验一下
export const Policies = [
    {
        "nodes": [
            { "name": "Jean Valjean", "category": "Character" },
            { "name": "Fantine", "category": "Character" },
            { "name": "Javert", "category": "Character" },
            { "name": "Cosette", "category": "Character" },
            { "name": "Marius Pontmercy", "category": "Character" },
            { "name": "Eponine", "category": "Character" },
            { "name": "Enjolras", "category": "Character" },
            { "name": "Thénardier", "category": "Character" },
            { "name": "Gavroche", "category": "Character" },
            { "name": "Paris", "category": "Location" },
            { "name": "Barricade", "category": "Location" }
        ],
        "links": [
            { "source": 0, "target": 1 },
            { "source": 0, "target": 2 },
            { "source": 3, "target": 4 },
            { "source": 3, "target": 5 },
            { "source": 3, "target": 6 },
            { "source": 7, "target": 8 },
            { "source": 4, "target": 6 },
            { "source": 4, "target": 9 },
            { "source": 5, "target": 9 },
            { "source": 5, "target": 10 }
        ],
        "categories": [
            { "name": "Character", "symbol": "circle" },
            { "name": "Location", "symbol": "rect" }
        ]
    }

]

