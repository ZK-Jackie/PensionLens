import json
from collections import defaultdict, deque
import math


def convert_to_echarts_format(file_path):
    with open(file_path, 'r', encoding='utf-8') as f:
        data = json.load(f)

    nodes = []
    links = []
    categories = []
    category_map = {}
    node_map = {}
    link_map = {}
    graph = defaultdict(list)
    distances = {}
    angles = defaultdict(lambda: 0)
    max_size = 70
    min_size = 20
    radius = 100

    for record in data:
        n = record['n']
        m = record['m']
        r = record['r']

        for node in [n, m]:
            category = node['labels'][0] if node['labels'] else None
            if category and category not in category_map:
                category_map[category] = len(categories)
                categories.append({'name': category})

            node_id = str(node['identity'])
            if node_id not in node_map:
                node_map[node_id] = {
                    'id': node_id,
                    'name': node['properties']['name'],
                    'category': category_map.get(node['labels'][0]) if node['labels'] else None
                }

        link_id = str(r['start']) + '-' + str(r['end'])
        if link_id not in link_map:
            link_map[link_id] = {
                'source': str(r['start']),
                'target': str(r['end']),
                'name': r['type']
            }
            links.append(link_map[link_id])

        graph[str(r['start'])].append(str(r['end']))
        graph[str(r['end'])].append(str(r['start']))

    # BFS to calculate distances
    root_id = str(data[0]['n']['identity'])
    queue = deque([(root_id, 0)])
    while queue:
        node_id, distance = queue.popleft()
        if node_id in distances:
            continue
        distances[node_id] = distance
        for neighbor in graph[node_id]:
            queue.append((neighbor, distance + 1))

    # Set x, y, and symbolSize based on distances
    max_distance = max(distances.values())
    for node_id, node in node_map.items():
        distance = distances.get(node_id, max_distance)
        angle = angles[distance]
        angles[distance] += 2 * math.pi / len(graph[node_id])
        node['x'] = distance * radius * math.cos(angle)
        node['y'] = distance * radius * math.sin(angle)
        node['symbolSize'] = max_size - (distance / max_distance) * (max_size - min_size)
        nodes.append(node)

    return {'nodes': nodes, 'links': links, 'categories': categories}


if __name__ == '__main__':
    data = convert_to_echarts_format('data/graph.json')
    with open('../src/components/echarts_data.json', 'w', encoding='utf-8') as f:
        json.dump(data, f, ensure_ascii=False, indent=4)
